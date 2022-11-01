package curso.java.tienda.index.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import curso.java.tienda.index.pojo.Producto;
import curso.java.tienda.util.Parametrizar;
import datos.Ordenacion;
import hibernate.HibernateSession;

public class CatalogoFilterService {

	public static HashMap<Integer, Producto> getProductoFilter(String criteria) {

		if (criteria != null) {

			StringBuilder hql = new StringBuilder();
			
			Parametrizar parametrizar = new Parametrizar();
			
			String param = null;

			hql.append("from productos p ");
			System.out.println(hql.toString());

			try {

				ObjectMapper mapper = new ObjectMapper();
				JsonNode root;

				root = mapper.readTree(criteria);

				// Obtener los ids de categoría seleccionados.

				if (!root.get("categories").isNull()) {
					if (root.get("categories").isArray()) {
						for (final JsonNode objNode : root.get("categories")) {

							//param = ":param" + parameterList.size();
							param = ":param" + parametrizar.getIndex();

							if (hql.indexOf("where") == -1) {
								hql.append("where p.categoria.id in (from categorias c where c.id = " + param);
								//parameterValue.put(parameterValue.size(), objNode.asInt());
								
								parametrizar.addValueParameter(objNode.asInt());
								
							} else {
								hql.append(" or c.id = " + param);
								//parameterValue.put(parameterValue.size(), objNode.asText());
								parametrizar.addValueParameter(objNode.asInt());
							}

						}
						
						hql.append(")");

						System.out.println(hql.toString());

					}
				}

				// Obtener intervalos de precio.

				int[] price = new int[2];

				if (!root.get("price").isNull()) {

					JsonNode priceNode = root.get("price");

					if (!priceNode.get("min").isNull() && !priceNode.get("max").isNull()) {

						if (hql.indexOf("where") == -1) {

							param = ":param" + parametrizar.getIndex();
							hql.append("where p.precio between " + param);
							//parameterValue.put(parameterValue.size(), priceNode.get("min").asText());
							parametrizar.addValueParameter(priceNode.get("min").asDouble());

							param = ":param" + parametrizar.getIndex();
							hql.append(" and " + param);
							//parameterValue.put(parameterValue.size(), priceNode.get("max").asText());
							parametrizar.addValueParameter(priceNode.get("max").asDouble());

						} else {

							param = ":param" + parametrizar.getIndex();
							hql.append(" and p.precio between " + param);
							//parameterValue.put(parameterValue.size(), priceNode.get("min").asText());
							parametrizar.addValueParameter(priceNode.get("min").asDouble());

							param = ":param" + parametrizar.getIndex();
							hql.append(" and " + param);
							//parameterValue.put(parameterValue.size(), priceNode.get("max").asText());
							parametrizar.addValueParameter(priceNode.get("max").asDouble());

						}

						System.out.println(hql.toString());

					}

				}

				// Obtener filtro de ordenación.

				if (!root.get("sort").isNull()) {

					int sortId = root.get("sort").asInt();

					switch (Ordenacion.criterio.valueOf(sortId)) {

					case LOWEST_PRICE:

						hql.append(" order by p.precio asc");
						break;

					case HIGHEST_PRICE:

						hql.append(" order by p.precio desc");
						break;

					case BEST_SELLERS:

						if (hql.indexOf("where") == -1) {
							hql.append("where p.stock < 20");
						} else {
							hql.append(" and p.stock < 20");
						}

						break;

					case TOP_RATED:

						if (hql.indexOf("where") == -1) {
							hql.append(" inner join valoraciones v on v.producto.id = p.id");
							hql.append(" group by p.id");
							hql.append(" order by avg(v.valoracion) desc");
						} else {

							int wherePosition = hql.indexOf("where");

							hql.insert(wherePosition - 1, " inner join valoraciones v on v.producto.id = p.id");
							hql.append(" group by p.id");
							hql.append(" order by avg(v.valoracion) desc");

						}

						break;

					}

					System.out.println(hql.toString());

				}

			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			doQuery(hql.toString(), parametrizar);

		}
		
		return null;

	}

	public static void doQuery(String hql, Parametrizar param) {

		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		Query query = session.createQuery(hql);

		
		int count = 0;
		
		/*for (String p : params.values()) {
			query.setParameter("param" + count, p);
			count++;
		}*/
		
		for (Object o : param.getParameters()) {
			query.setParameter("param" + count, o);
			count++;
		}
		
		
		/*
		 * query.setParameter("p3", (double) 1000); query.setParameter("p4", (double)
		 * 3000);
		 */

		List<Object> results = query.list();

		session.close();
		sessionFactory.close();

	}

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		/*Query query = session.createQuery(
				"from productos p inner join valoraciones v on v.producto.id = p.id where  p.categoria.id = :id1 OR p.categoria.id = :id2 order by v.valoracion DESC");*/
		
		Query query = session.createQuery("from productos p where p.categoria.id in (from categorias c where c.id = 1 or c.id = 4)");
		
		/*query.setParameter("id1", 1);
		query.setParameter("id2", 4);*/
		/*
		 * query.setParameter("p3", (double) 1000); query.setParameter("p4", (double)
		 * 3000);
		 */

		List<Object> results = query.list();

		session.close();
		sessionFactory.close();

		// System.out.println(Ordenacion.criterio.valueOf(0));

	}

}
