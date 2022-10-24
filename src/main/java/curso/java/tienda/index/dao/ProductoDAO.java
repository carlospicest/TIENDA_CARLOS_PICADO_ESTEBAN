package curso.java.tienda.index.dao;

import java.util.ArrayList;

import curso.java.tienda.index.pojo.Producto;

public interface ProductoDAO {

	public ArrayList<Producto> getProductos();
	
	public Producto getProducto(int idProduct);
	
}
