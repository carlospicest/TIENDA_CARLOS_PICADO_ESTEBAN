package curso.java.tienda.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import curso.java.tienda.pojo.Usuario;
import hibernate.HibernateSession;


public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public int addUsuario(Usuario usuario) {

		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();

			session.save(usuario);

			session.getTransaction().commit();

			session.close();
			sessionFactory.close();
			
		} catch (Exception e) {
			System.out.println("[ERROR] " + UsuarioDAOImpl.class.getCanonicalName() + " => " + e.getMessage());
		}

		return usuario.getId();

	}

	
	@Override
	public ArrayList<Usuario> getUsuario() {

		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from usuarios");
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) query.list();

		session.close();
		sessionFactory.close();
		
		return usuarios;

	}

	@Override
	public Usuario getUsuario(int id) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from usuarios u where u.id = :idUsuario");
		query.setParameter("idUsuario", id);
		Usuario usuario = (Usuario) query.uniqueResult();

		session.close();
		sessionFactory.close();
		
		return usuario;
		
		
	}
	
	@Override
	public Usuario getUsuario(String email) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from usuarios u where u.email = :email");
		query.setParameter("email", email);
		Usuario usuario = (Usuario) query.uniqueResult();

		session.close();
		sessionFactory.close();
		
		return usuario;
		
	}
	
	@Override
	public boolean updateUsuario(Usuario usuario) {
		
		boolean result = false;
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.update(usuario);
		session.getTransaction().commit();
		
		result = true;
		
		session.close();
		sessionFactory.close();
		
		return result;
	}
	
	@Override
	public boolean deleteUsuario(Usuario usuario) {
		
		boolean result = false;
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.remove(usuario);
		session.getTransaction().commit();
		session.close();

		sessionFactory.close();
		
		return result;
	}
	
}
