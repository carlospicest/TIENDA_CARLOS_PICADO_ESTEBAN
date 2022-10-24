package curso.java.tienda.dao;

import java.util.ArrayList;

import curso.java.tienda.pojo.Producto;

public interface ProductoDAO {

	public ArrayList<Producto> getProductos();
	
	public Producto getProducto(int idProduct);
	
}
