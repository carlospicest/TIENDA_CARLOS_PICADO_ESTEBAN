package curso.java.tienda.controller.catalogo;

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
 * Servlet implementation class CatalogoController
 */
@WebServlet("/catalogo")
public class CatalogoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Categoria> categoryList = new CategoriaDAOImpl().getCategorias();
		ArrayList<Producto> productList = new ProductoDAOImpl().getProductos();
		
		request.setAttribute("productList", productList);
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher(WebPath.URL.CATALOGO_JSP.toString()).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
