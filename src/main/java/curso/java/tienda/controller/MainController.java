package curso.java.tienda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.dao.CategoriaDAOImpl;
import curso.java.tienda.dao.ProductoDAOImpl;
import curso.java.tienda.pojo.Categoria;
import curso.java.tienda.pojo.Producto;
import mapping.WebPath;


/**
 * Servlet implementation class MainController
 */
@WebServlet("")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtenemos categorias.
		
		ArrayList<Categoria> listaCategorias = new CategoriaDAOImpl().getCategorias();
		request.setAttribute("listaCategorias", listaCategorias);
		
		// Obtenemos productos.
		
		ArrayList<Producto> listaProductos = new ProductoDAOImpl().getProductos();
		request.setAttribute("listaProductos", listaProductos);
		
		request.getRequestDispatcher(WebPath.URL.INDEX.toString()).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
