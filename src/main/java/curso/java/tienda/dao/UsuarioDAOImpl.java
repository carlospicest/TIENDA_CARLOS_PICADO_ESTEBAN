package curso.java.tienda.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import curso.java.tienda.pojo.Usuario;
import curso.java.tienda.util.DateTime;
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
		
		return result;
	}
	
	public static void main(String[] args) {
		
		Usuario u = new Usuario();
		u.setNombre("Carlos");
		u.setApellido1("Picado");
		u.setApellido2("Esteban");
		u.setEmail("cap@gmail.com");
		u.setPassword("sna");
		u.setSalt("sdaws");
		u.setDireccion("dsa");
		u.setProvincia("SA");
		u.setLocalidad("sa");
		u.setTelefono("sadsa");
		u.setDni("sadsadsa");
		u.setFecha_alta(DateTime.getCurrentTime());
		
		new UsuarioDAOImpl().addUsuario(u);
		
	}
	

}
