package curso.java.tienda.index.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import curso.java.tienda.index.pojo.DetalleCarrito;
import hibernate.HibernateSession;

public class DetalleCarritoDAOImpl implements DetalleCarritoDAO {

	@Override
	public int addDetalleCarrito(DetalleCarrito cartDetail) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();

			session.save(cartDetail);

			session.getTransaction().commit();

			session.close();
			sessionFactory.close();
			
		} catch (Exception e) {
			System.out.println("[ERROR] " + DetalleCarritoDAOImpl.class.getCanonicalName() + " => " + e.getMessage());
		}

		return cartDetail.getId();
	}

}
