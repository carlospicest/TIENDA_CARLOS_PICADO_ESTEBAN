package curso.java.tienda.index.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import curso.java.tienda.index.pojo.DetallePedido;
import curso.java.tienda.index.pojo.Pedido;

public interface DetallePedidoDAO {
	
	public LinkedHashMap<Integer, DetallePedido> getDetallesPedido(Pedido pedido);
	
	public ArrayList<DetallePedido> getDetallesByPedido(Pedido pedido);
	
	public int addDetallePedido(DetallePedido detallePedido);
	
	public boolean updateDetallePedido(DetallePedido detallePedido);
	
}
