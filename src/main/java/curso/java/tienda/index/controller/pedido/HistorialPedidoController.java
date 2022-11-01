package curso.java.tienda.index.controller.pedido;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.index.dao.PedidoDAOImpl;
import curso.java.tienda.index.pojo.Pedido;
import curso.java.tienda.index.pojo.Usuario;

/**
 * Servlet implementation class PedidoController
 */
@WebServlet("/historial_pedido")
public class HistorialPedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistorialPedidoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario user = (Usuario) request.getSession().getAttribute("userdata");
		
		if (user != null) {
			
			LinkedHashMap<Integer, Pedido> pedidosList = new PedidoDAOImpl().getPedidos(user);
			
			request.setAttribute("pedidosList", pedidosList);
			request.getRequestDispatcher("index/historial_pedidos.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
