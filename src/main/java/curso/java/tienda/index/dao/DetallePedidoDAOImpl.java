package curso.java.tienda.index.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import curso.java.tienda.index.pojo.DetallePedido;
import curso.java.tienda.index.pojo.Pedido;
import hibernate.HibernateSession;

public class DetallePedidoDAOImpl implements DetallePedidoDAO {

	@Override
	public LinkedHashMap<Integer, DetallePedido> getDetallesPedido(Pedido pedido) {

		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from detalles_pedido dp where dp.pedido.id = :idPedido");
		query.setParameter("idPedido", pedido.getId());
		List<DetallePedido> detallesPedido = query.list();

		session.close();
		sessionFactory.close();

		LinkedHashMap<Integer, DetallePedido> detallePedidoList = new LinkedHashMap<>();

		if (detallesPedido != null && !detallesPedido.isEmpty()) {

			for (DetallePedido detallePedido : detallesPedido) {
				detallePedidoList.put(detallePedido.getId(), detallePedido);
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

	@Override
	public ArrayList<DetallePedido> getDetallesByPedido(Pedido pedido) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from detalles_pedido dp where dp.pedido.id = :idPedido");
		query.setParameter("idPedido", pedido.getId());
		ArrayList<DetallePedido> detallesPedido = (ArrayList<DetallePedido>) query.list();

		session.close();
		sessionFactory.close();

		return detallesPedido;
		
	}

}
