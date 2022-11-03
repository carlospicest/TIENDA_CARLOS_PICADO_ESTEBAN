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

	@Override
	public int addProducto(Producto producto) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();

			session.save(producto);

			session.getTransaction().commit();

			session.close();
			sessionFactory.close();
			
		} catch (Exception e) {
			System.out.println("[ERROR] " + ProductoDAOImpl.class.getCanonicalName() + " => " + e.getMessage());
		}
		
		return producto.getId();
		
	}
	
	@Override
	public boolean updateProducto(Producto producto) {
		
		boolean result = false;
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.update(producto);
		session.getTransaction().commit();
		
		result = true;
		
		session.close();
		sessionFactory.close();
		
		return result;
		
	}

	@Override
	public boolean deleteProducto(Producto producto) {
		
		boolean result = false;
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.delete(producto);
		session.getTransaction().commit();
		
		result = true;
		
		session.close();
		sessionFactory.close();
		
		return result;
		
	}

}
