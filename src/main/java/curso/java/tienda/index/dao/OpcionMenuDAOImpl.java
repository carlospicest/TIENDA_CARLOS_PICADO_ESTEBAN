package curso.java.tienda.index.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import curso.java.tienda.index.pojo.OpcionMenu;
import hibernate.HibernateSession;

public class OpcionMenuDAOImpl implements OpcionMenuDAO {

	@Override
	public ArrayList<OpcionMenu> getOpcionMenu() {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from opciones_menu om");
		ArrayList<OpcionMenu> opcionMenuList = (ArrayList<OpcionMenu>) query.list();

		session.close();
		sessionFactory.close();
		
		return opcionMenuList;
				
	}

	@Override
	public HashMap<String, OpcionMenu> getOpcionMenu(int idRol) {
		
		SessionFactory sessionFactory = HibernateSession.makeSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from opciones_menu om where om.rol.id = :idRol");
		query.setParameter("idRol", idRol);
		ArrayList<OpcionMenu> opcionMenuList = (ArrayList<OpcionMenu>) query.list();

		session.close();
		sessionFactory.close();
		
		HashMap<String, OpcionMenu> opcionMenu = new HashMap<String, OpcionMenu>();
		
		for (OpcionMenu opcion : opcionMenuList) {
			opcionMenu.put(opcion.getOpcion().getAlias(), opcion);
		}
		
		return opcionMenu;
		
	}

}
