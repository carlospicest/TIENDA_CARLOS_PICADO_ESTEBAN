package curso.java.tienda.index.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import curso.java.tienda.index.pojo.Producto;
import hibernate.HibernateSession;

public class ProductoDAOImpl implements ProductoDAO {

	@Override
	public HashMap<Integer, Producto> getProductos() {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		Query query = session.createQuery("from productos");
		List<Producto> productos = (ArrayList<Producto>) query.list();

		session.close();
		sessionFactory.close();
		
		HashMap<Integer, Producto> productoList = new HashMap<>();
		
		if (productos != null && !productos.isEmpty()) {
			
			for (Producto pedido : productos) {
				productoList.put(pedido.getId(), pedido);
			}
			
		}
		
		return productoList;
		
	}

	@Override
	public Producto getProducto(int idProduct) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		Query query = session.createQuery("from productos p where p.id = :idProduct");
		query.setParameter("idProduct", idProduct);
		Producto producto = (Producto) query.uniqueResult();

		session.close();
		sessionFactory.close();
		
		return producto;
		
	}

}
