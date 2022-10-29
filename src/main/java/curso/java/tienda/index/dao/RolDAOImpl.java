package curso.java.tienda.index.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import curso.java.tienda.index.pojo.Rol;
import hibernate.HibernateSession;

public class RolDAOImpl implements RolDAO {

	@Override
	public Rol getRol(String rolename) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from roles r where r.rol like :rol");
		query.setParameter("rol", "%" + rolename + "%");
		Rol role = (Rol) query.uniqueResult();

		session.close();
		sessionFactory.close();
		
		return role;
	}

	@Override
	public Rol getRol(int id) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from roles r where r.id = :idRol");
		query.setParameter("idRol", id);
		Rol role = (Rol) query.uniqueResult();

		session.close();
		sessionFactory.close();
		
		return role;
		
	}

}
