package curso.java.tienda.index.dao;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import curso.java.tienda.index.pojo.Opcion;
import hibernate.HibernateSession;

public class OpcionDAOImpl implements OpcionDAO {

	@Override
	public ArrayList<Opcion> getOpciones() {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from opciones o");
		ArrayList<Opcion> opcionesList = (ArrayList<Opcion>) query.list();

		session.close();
		sessionFactory.close();
		
		return opcionesList;
		
	}

}
