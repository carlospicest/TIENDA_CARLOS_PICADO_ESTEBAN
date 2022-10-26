package curso.java.tienda.index.dao;

import java.util.HashMap;

import curso.java.tienda.index.pojo.DetallePedido;
import curso.java.tienda.index.pojo.Pedido;

public interface DetallePedidoDAO {
	
	public HashMap<Integer, DetallePedido> getDetallePedido(Pedido pedido);
	
	public int addDetallePedido(DetallePedido detallePedido);
	
	public boolean updateDetallePedido(DetallePedido detallePedido);
	
}
