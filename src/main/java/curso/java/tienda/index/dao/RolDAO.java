package curso.java.tienda.index.dao;

import curso.java.tienda.index.pojo.Rol;

public interface RolDAO {

	public Rol getRol(String rolename);
	
	public Rol getRol(int id);
	
}
