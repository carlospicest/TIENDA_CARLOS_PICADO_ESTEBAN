package curso.java.tienda.index.dao;

import java.util.ArrayList;

import curso.java.tienda.index.pojo.Carrito;

public interface CarritoDAO {

	public ArrayList<Carrito> getCarrito(int idUser);
	
	public int addCarrito(Carrito carrito);
	
}
