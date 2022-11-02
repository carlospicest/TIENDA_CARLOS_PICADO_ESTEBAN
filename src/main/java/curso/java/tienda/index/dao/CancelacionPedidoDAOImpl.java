package curso.java.tienda.index.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import curso.java.tienda.index.pojo.CancelacionPedido;
import hibernate.HibernateSession;

public class CancelacionPedidoDAOImpl implements CancelacionPedidoDAO {

	@Override
	public int addCancelacionPedido(CancelacionPedido cancelacionPedido) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();

			session.save(cancelacionPedido);

			session.getTransaction().commit();

			session.close();
			sessionFactory.close();
			
		} catch (Exception e) {
			System.out.println("[ERROR] " + CancelacionPedidoDAOImpl.class.getCanonicalName() + " => " + e.getMessage());
		}

		return cancelacionPedido.getId();
		
	}

}
