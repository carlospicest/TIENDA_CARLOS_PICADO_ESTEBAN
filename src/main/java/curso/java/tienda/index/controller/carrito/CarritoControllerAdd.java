package curso.java.tienda.index.controller.carrito;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.index.pojo.DetallePedido;
import curso.java.tienda.index.service.CarritoService;

/**
 * Servlet implementation class CarritoControllerAdd
 */
@WebServlet("/carrito_add")
public class CarritoControllerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarritoControllerAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recogemos los datos sobre el id del producto y las unidades.
		
		Integer idProduct = Integer.parseInt(request.getParameter("idProduct"));
		Integer stack = Integer.parseInt(request.getParameter("stack"));

		HashMap<Integer, DetallePedido> cartList = (HashMap<Integer, DetallePedido>) request.getSession().getAttribute("cart");
		
		String jsonResponse = CarritoService.addProductCart(idProduct, stack, cartList);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
