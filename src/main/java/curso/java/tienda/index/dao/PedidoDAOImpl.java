package curso.java.tienda.index.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import curso.java.tienda.index.pojo.Pedido;
import curso.java.tienda.index.pojo.Usuario;
import hibernate.HibernateSession;

public class PedidoDAOImpl implements PedidoDAO {

	@Override
	public HashMap<Integer, Pedido> getPedidos() {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from pedidos p");
		List<Pedido> pedidos = query.list();

		session.close();
		sessionFactory.close();

		HashMap<Integer, Pedido> pedidoList = new HashMap<>();
		
		if (pedidos != null && !pedidos.isEmpty()) {
			
			for (Pedido pedido : pedidos) {
				pedidoList.put(pedido.getId(), pedido);
			}
			
		}
				
		return pedidoList;
		
	}

	@Override
	public HashMap<Integer, Pedido> getPedidos(Usuario user) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from pedidos p where p.usuario.id = :userId");
		query.setParameter("userId", user.getId());
		List<Pedido> pedidos = query.list();

		session.close();
		sessionFactory.close();

		HashMap<Integer, Pedido> pedidoList = new HashMap<>();
		
		if (pedidos != null && !pedidos.isEmpty()) {
			
			for (Pedido pedido : pedidos) {
				pedidoList.put(pedido.getId(), pedido);
			}
			
		}
				
		return pedidoList;
		
	}

}
