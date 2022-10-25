package curso.java.tienda.index.dao;

import java.util.HashMap;

import curso.java.tienda.index.pojo.DetalleCarrito;

public interface DetalleCarritoDAO {
	
	public HashMap<Integer, DetalleCarrito> getDetalleCarrito(int idCart);
	
	public int addDetalleCarrito(DetalleCarrito cartDetail);
	
}
