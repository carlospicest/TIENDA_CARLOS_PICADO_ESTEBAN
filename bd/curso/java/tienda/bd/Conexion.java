package curso.java.tienda.bd;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import curso.java.tienda.util.Util;

public class Conexion {

	static String url = "jdbc:mysql://";
	static Connection conexion; // atributo para guardar el objeto Connection

	public static Connection getConexion() {
		if (conexion == null) {
			crearConexion();
		}
		return conexion;
	}

	// devuelve true si se ha creado correctamente
	public static boolean crearConexion() {
		try {
			
			String dbPropPath = Util.getResource("connection.properties");
			
			InputStream input = new FileInputStream(dbPropPath);
			
			Properties dbProp = new Properties();
			dbProp.load(input);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url + dbProp.getProperty("host") + "/" + 
														 dbProp.getProperty("database"), 
														 dbProp.getProperty("user"), 
														 dbProp.getProperty("password"));

			conexion.setAutoCommit(false);

		} catch (SQLException e) {
			System.err.println("ERROR " + Conexion.class.getCanonicalName() + " => " + e.getMessage());
			return false;
		} catch (Exception e) {
			System.err.println("ERROR " + Conexion.class.getCanonicalName() + " => " + e.getMessage());
			return false;
		}
		return true;
	}

	public static void desconectar() {
		try {
			conexion.close();
			conexion = null;
			System.out.println("La conexion a la  base de datos ha terminado");

		} catch (SQLException e) {
			System.err.println("ERROR " + Conexion.class.getCanonicalName() + " => " + e.getMessage());
		}
	}

}
