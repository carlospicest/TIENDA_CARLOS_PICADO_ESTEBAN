package curso.java.tienda.index.dao;

import java.util.HashMap;

import curso.java.tienda.index.pojo.Pedido;
import curso.java.tienda.index.pojo.Usuario;

public interface PedidoDAO {

	public HashMap<Integer, Pedido> getPedidos();
	
	public HashMap<Integer, Pedido> getPedidos(Usuario user);
	
}
