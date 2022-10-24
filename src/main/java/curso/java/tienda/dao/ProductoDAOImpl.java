package curso.java.tienda.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import curso.java.tienda.pojo.Producto;
import curso.java.tienda.pojo.Usuario;
import hibernate.HibernateSession;

public class ProductoDAOImpl implements ProductoDAO {

	@Override
	public ArrayList<Producto> getProductos() {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from productos");
		ArrayList<Producto> productos = (ArrayList<Producto>) query.list();

		session.close();
		sessionFactory.close();
		
		return productos;
		
	}

	@Override
	public Producto getProducto(int idProduct) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from productos p where p.id = :idProduct");
		query.setParameter("idProduct", idProduct);
		Producto producto = (Producto) query.uniqueResult();

		session.close();
		sessionFactory.close();
		
		return producto;
		
	}

}
