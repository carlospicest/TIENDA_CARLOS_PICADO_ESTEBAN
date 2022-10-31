package curso.java.tienda.index.dao;

import java.util.HashMap;

import curso.java.tienda.index.pojo.MetodoPago;

public interface MetodoPagoDAO {

	public HashMap<Integer, MetodoPago> getMetodoPago();
	
	public MetodoPago getMetodoPago(int id);
	
}
