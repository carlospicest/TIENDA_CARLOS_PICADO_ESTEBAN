package curso.java.tienda.index.controller.detalle_pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.index.dao.DetallePedidoDAOImpl;
import curso.java.tienda.index.dao.PedidoDAOImpl;
import curso.java.tienda.index.pojo.DetallePedido;
import curso.java.tienda.index.pojo.Pedido;

/**
 * Servlet implementation class DetallePedidoShowController
 */
@WebServlet("/detalle_pedido")
public class DetallePedidoShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallePedidoShowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			Integer idPedido = Integer.parseInt(request.getParameter("pedido"));
			
			Pedido pedido = new PedidoDAOImpl().getPedido(idPedido);
			
			if (pedido != null) {
				ArrayList<DetallePedido> detallePedido = new DetallePedidoDAOImpl().getDetallesByPedido(pedido);
				request.setAttribute("detallePedido", detallePedido);
				request.getRequestDispatcher("index/detalle_pedido.jsp").forward(request, response);
			}
			
			 
			
		} catch (NumberFormatException e) {
			
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
