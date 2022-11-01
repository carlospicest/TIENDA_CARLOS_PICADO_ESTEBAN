package curso.java.tienda.index.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import curso.java.tienda.index.pojo.Pedido;
import curso.java.tienda.index.pojo.Usuario;
import hibernate.HibernateSession;

public class PedidoDAOImpl implements PedidoDAO {

	@Override
	public LinkedHashMap<Integer, Pedido> getPedidos() {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from pedidos p");
		List<Pedido> pedidos = query.list();

		session.close();
		sessionFactory.close();

		LinkedHashMap<Integer, Pedido> pedidoList = new LinkedHashMap<>();
		
		if (pedidos != null && !pedidos.isEmpty()) {
			
			for (Pedido pedido : pedidos) {
				pedidoList.put(pedido.getId(), pedido);
			}
			
		}
				
		return pedidoList;
		
	}

	@Override
	public LinkedHashMap<Integer, Pedido> getPedidos(Usuario user) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from pedidos p where p.usuario.id = :userId");
		query.setParameter("userId", user.getId());
		List<Pedido> pedidos = query.list();

		session.close();
		sessionFactory.close();

		LinkedHashMap<Integer, Pedido> pedidoList = new LinkedHashMap<>();
		
		if (pedidos != null && !pedidos.isEmpty()) {
			
			for (Pedido pedido : pedidos) {
				pedidoList.put(pedido.getId(), pedido);
			}
			
		}
				
		return pedidoList;
		
	}

	@Override
	public int addPedido(Pedido pedido) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();

			session.save(pedido);

			session.getTransaction().commit();

			session.close();
			sessionFactory.close();
			
		} catch (Exception e) {
			System.out.println("[ERROR] " + PedidoDAOImpl.class.getCanonicalName() + " => " + e.getMessage());
		}

		return pedido.getId();

	}

	@Override
	public Pedido getPedido(int idPedido) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from pedidos p where p.id = :idPedido");
		query.setParameter("idPedido", idPedido);
		Pedido pedido = (Pedido) query.uniqueResult();

		session.close();
		sessionFactory.close();
		
		return pedido;
		
	}

}
