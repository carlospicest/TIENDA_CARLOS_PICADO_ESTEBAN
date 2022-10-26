package curso.java.tienda.index.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import curso.java.tienda.index.pojo.DetallePedido;
import curso.java.tienda.index.pojo.Pedido;
import hibernate.HibernateSession;

public class DetallePedidoDAOImpl implements DetallePedidoDAO {

	@Override
	public HashMap<Integer, DetallePedido> getDetallePedido(Pedido pedido) {

		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from detalles_pedido dp where dp.pedido.id = :idPedido");
		query.setParameter("idPedido", pedido.getId());
		List<DetallePedido> detallesPedido = query.list();

		session.close();
		sessionFactory.close();

		HashMap<Integer, DetallePedido> detallePedidoList = new HashMap<>();

		if (detallesPedido != null && !detallesPedido.isEmpty()) {

			for (DetallePedido detallePedido : detallesPedido) {
				detallePedidoList.put(pedido.getId(), detallePedido);
			}

		}

		return detallePedidoList;

	}

	@Override
	public int addDetallePedido(DetallePedido detallePedido) {

		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();

			session.save(detallePedido);

			session.getTransaction().commit();

			session.close();
			sessionFactory.close();

		} catch (Exception e) {
			System.out.println("[ERROR] " + DetallePedidoDAOImpl.class.getCanonicalName() + " => " + e.getMessage());
		}

		return detallePedido.getId();

	}

	@Override
	public boolean updateDetallePedido(DetallePedido detallePedido) {

		boolean result = false;

		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.update(detallePedido);
		session.getTransaction().commit();

		result = true;

		session.close();
		sessionFactory.close();

		return result;

	}

}
