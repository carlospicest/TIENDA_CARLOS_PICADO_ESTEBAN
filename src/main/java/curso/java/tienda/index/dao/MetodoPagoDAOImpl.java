package curso.java.tienda.index.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import curso.java.tienda.index.pojo.DetallePedido;
import curso.java.tienda.index.pojo.MetodoPago;
import hibernate.HibernateSession;

public class MetodoPagoDAOImpl implements MetodoPagoDAO {

	@Override
	public HashMap<Integer, MetodoPago> getMetodoPago() {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from metodos_pago mp");
		List<MetodoPago> metodoPago = query.list();

		session.close();
		sessionFactory.close();

		HashMap<Integer, MetodoPago> metodoPagoList = new HashMap<>();

		if (metodoPago != null && !metodoPago.isEmpty()) {

			for (MetodoPago metodo : metodoPago) {
				metodoPagoList.put(metodo.getId(), metodo);
			}

		}
		
		return metodoPagoList;
		
	}

	@Override
	public MetodoPago getMetodoPago(int id) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from metodo_pago mp where mp.id = :idMetodoPago");
		query.setParameter("idMetodoPago", id);
		MetodoPago metodoPago = (MetodoPago) query.uniqueResult();

		session.close();
		sessionFactory.close();
		
		return metodoPago;
		
	}

}
