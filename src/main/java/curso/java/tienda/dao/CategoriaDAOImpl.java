package curso.java.tienda.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import curso.java.tienda.pojo.Categoria;
import hibernate.HibernateSession;

public class CategoriaDAOImpl implements CategoriaDAO {

	@Override
	public ArrayList<Categoria> getCategorias() {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from categorias");
		ArrayList<Categoria> categorias = (ArrayList<Categoria>) query.list();

		sessionFactory.close();
	
		return categorias;
		
	}

}
