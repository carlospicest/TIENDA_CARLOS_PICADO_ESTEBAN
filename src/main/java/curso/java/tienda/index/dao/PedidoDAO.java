package curso.java.tienda.index.dao;

import java.util.LinkedHashMap;

import curso.java.tienda.index.pojo.Pedido;
import curso.java.tienda.index.pojo.Usuario;

public interface PedidoDAO {

	public LinkedHashMap<Integer, Pedido> getPedidos();
	
	public LinkedHashMap<Integer, Pedido> getPedidos(Usuario user);
	
	public Pedido getPedido(int idPedido);
	
	public int addPedido(Pedido pedido);
	
}
