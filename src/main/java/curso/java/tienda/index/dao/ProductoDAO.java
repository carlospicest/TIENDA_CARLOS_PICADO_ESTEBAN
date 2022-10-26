package curso.java.tienda.index.dao;

import java.util.HashMap;

import curso.java.tienda.index.pojo.Producto;

public interface ProductoDAO {

	public HashMap<Integer, Producto> getProductos();
	
	public Producto getProducto(int idProduct);
	
}
