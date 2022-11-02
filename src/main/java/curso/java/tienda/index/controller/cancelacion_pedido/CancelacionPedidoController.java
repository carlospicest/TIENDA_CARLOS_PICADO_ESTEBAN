package curso.java.tienda.index.controller.cancelacion_pedido;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.index.dao.PedidoDAOImpl;
import curso.java.tienda.index.pojo.Pedido;

/**
 * Servlet implementation class CancelacionPedidoController
 */
@WebServlet("/cancelacion_pedido")
public class CancelacionPedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelacionPedidoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idPedido = Integer.parseInt(request.getParameter("pedido"));
		
		Pedido pedido = new PedidoDAOImpl().getPedido(idPedido);
		
		if (pedido != null) {
			request.getSession().setAttribute("pedidoCancelId", pedido.getId());
			request.setAttribute("pedido", pedido);
			request.getRequestDispatcher("index/cancelacion_pedido.jsp").forward(request, response);
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
