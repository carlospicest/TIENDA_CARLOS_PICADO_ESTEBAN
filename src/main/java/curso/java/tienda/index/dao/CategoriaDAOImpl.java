package curso.java.tienda.index.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import curso.java.tienda.index.pojo.Categoria;
import hibernate.HibernateSession;

public class CategoriaDAOImpl implements CategoriaDAO {

	@Override
	public ArrayList<Categoria> getCategorias() {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from categorias");
		ArrayList<Categoria> categorias = (ArrayList<Categoria>) query.list();

		session.close();
		sessionFactory.close();
	
		return categorias;
		
	}

	@Override
	public Categoria getCategoria(int id) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from categorias where id = :id");
		query.setParameter("id", id);
		Categoria categoria = (Categoria) query.uniqueResult();

		session.close();
		sessionFactory.close();
		
		return categoria;
	}

}
