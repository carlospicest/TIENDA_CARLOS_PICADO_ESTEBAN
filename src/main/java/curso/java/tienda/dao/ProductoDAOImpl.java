package curso.java.tienda.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import curso.java.tienda.pojo.Producto;
import hibernate.HibernateSession;

public class ProductoDAOImpl implements ProductoDAO {

	@Override
	public ArrayList<Producto> getProductos() {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from productos");
		ArrayList<Producto> productos = (ArrayList<Producto>) query.list();

		sessionFactory.close();
		
		return productos;
		
	}

}
