

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import curso.java.tienda.pojo.Usuario;

public class HibernateSession {

	private static final String HIBERNATE_FILE = "hibernate.cfg.xml";
	
	public static SessionFactory makeSessionFactory() {
		
		return new Configuration()
								 .configure(HIBERNATE_FILE)
								 .addAnnotatedClass(Usuario.class)
								 .buildSessionFactory();
		
	}
	
}
