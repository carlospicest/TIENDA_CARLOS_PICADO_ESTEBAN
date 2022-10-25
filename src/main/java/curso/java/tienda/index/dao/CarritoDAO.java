package curso.java.tienda.index.dao;

import java.util.ArrayList;

import curso.java.tienda.index.pojo.Carrito;
import curso.java.tienda.index.pojo.Usuario;

public interface CarritoDAO {

	public Carrito getCarritoUnproccessed(Usuario user);
	
	public ArrayList<Carrito> getCarrito(int idUser);
	
	public int addCarrito(Carrito carrito);
	
}
