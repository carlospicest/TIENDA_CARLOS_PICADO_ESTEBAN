package curso.java.tienda.index.dao;

import java.util.ArrayList;
import java.util.HashMap;

import curso.java.tienda.index.pojo.OpcionMenu;

public interface OpcionMenuDAO {

	public ArrayList<OpcionMenu> getOpcionMenu();
	
	public HashMap<String, OpcionMenu> getOpcionMenu(int idRol);
	
}
