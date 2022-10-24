package curso.java.tienda.dao;

import java.util.ArrayList;

import curso.java.tienda.pojo.Carrito;

public interface CarritoDAO {

	public ArrayList<Carrito> getCarrito(int idUser);
	
	public int addCarrito(Carrito carrito);
	
}
