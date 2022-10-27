package curso.java.tienda.index.controller.carrito;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import curso.java.tienda.index.pojo.DetallePedido;

/**
 * Servlet implementation class CarritoDeleteController
 */
@WebServlet("/carrito_delete")
public class CarritoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<Integer, DetallePedido> cartList = (HashMap<Integer, DetallePedido>) request.getSession().getAttribute("cart");
		
		Integer idProduct = Integer.parseInt(request.getParameter("idProduct"));
		boolean deleteResult = false;
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode deleteInformation = mapper.createObjectNode();
		
		if (cartList != null) {
			DetallePedido detallePedido = cartList.get(idProduct);	
			deleteResult = cartList.remove(idProduct, detallePedido);
		}
		
		deleteInformation.put("result", deleteResult);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(deleteInformation));
		out.flush();
		
	}

}
