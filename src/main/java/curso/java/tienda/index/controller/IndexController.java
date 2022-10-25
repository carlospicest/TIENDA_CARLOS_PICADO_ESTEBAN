package curso.java.tienda.index.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.index.dao.CategoriaDAOImpl;
import curso.java.tienda.index.dao.ProductoDAOImpl;
import curso.java.tienda.index.pojo.Carrito;
import curso.java.tienda.index.pojo.Categoria;
import curso.java.tienda.index.pojo.DetalleCarrito;
import curso.java.tienda.index.pojo.Producto;
import curso.java.tienda.index.pojo.Usuario;
import curso.java.tienda.index.service.CarritoService;
import mapping.WebPath;


/**
 * Servlet implementation class MainController
 */
@WebServlet("")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(WebPath.URL.INDEX_JSP.toString()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
