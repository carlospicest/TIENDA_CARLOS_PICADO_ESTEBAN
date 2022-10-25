package curso.java.tienda.index.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import curso.java.tienda.index.pojo.Carrito;
import curso.java.tienda.index.pojo.Usuario;
import hibernate.HibernateSession;

public class CarritoDAOImpl implements CarritoDAO {


	@Override
	public Carrito getCarritoUnproccessed(Usuario user) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from carritos c where c.usuario.id = :idUser and c.checkout = 0");
		query.setParameter("idUser", user.getId());
		Carrito carrito = (Carrito) query.uniqueResult();

		session.close();
		sessionFactory.close();
		
		return carrito;
		
	}
	
	@Override
	public ArrayList<Carrito> getCarrito(int idUser) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from carritos c where c.usuario.id = :idUser");
		query.setParameter("idUser", idUser);
		ArrayList<Carrito> carrito = (ArrayList<Carrito>) query.list();

		session.close();
		sessionFactory.close();
		
		return carrito;
		
	}
	
	@Override
	public int addCarrito(Carrito carrito) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();

			session.save(carrito);

			session.getTransaction().commit();

			session.close();
			sessionFactory.close();

		} catch (Exception e) {
			System.out.println("[ERROR] " + CarritoDAOImpl.class.getCanonicalName() + " => " + e.getMessage());
		}

		return carrito.getId();
		
	}

}
