package curso.java.tienda.controller.carrito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.pojo.Carrito;
import curso.java.tienda.pojo.DetalleCarrito;
import curso.java.tienda.pojo.Usuario;
import curso.java.tienda.service.CarritoService;

/**
 * Servlet implementation class CarritoController
 */
@WebServlet("/carrito")
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Primero comprobamos si el usuario está logueado, si es así el carrito pasa a persistir en BD.
		
		Usuario user;
		
		if ((user = (Usuario) request.getSession().getAttribute("userdata")) == null) {
			
			// Carrito en sesión (El usuario no ha iniciado sesión).
			
			HashMap<Integer, DetalleCarrito> cart = (HashMap<Integer, DetalleCarrito>) request.getSession().getAttribute("cart");
			
			//String cartJSON = CarritoService.getJSONCarrito(cart);
			
			System.out.println("");
			
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
