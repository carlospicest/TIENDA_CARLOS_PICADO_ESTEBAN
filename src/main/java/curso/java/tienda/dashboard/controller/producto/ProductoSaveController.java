package curso.java.tienda.dashboard.controller.producto;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.index.dao.CategoriaDAOImpl;
import curso.java.tienda.index.dao.ProductoDAOImpl;
import curso.java.tienda.index.pojo.Categoria;
import curso.java.tienda.index.pojo.Producto;

/**
 * Servlet implementation class AltaProductoController
 */
@WebServlet("/producto_agregar")
public class ProductoSaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoSaveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Categoria> categoriaList = new CategoriaDAOImpl().getCategorias();
		
		request.setAttribute("categoriaList", categoriaList);
		request.getRequestDispatcher("dashboard/producto/alta_producto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Categoria categoria = null;
			
			// Obtenemos parámetros del formulario.
			
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			Integer categoriaId = Integer.parseInt(request.getParameter("categoria"));
			categoria = new CategoriaDAOImpl().getCategoria(categoriaId);
			Double precio = Double.parseDouble(request.getParameter("precio").replace(",", "."));
			Integer stock = Integer.parseInt(request.getParameter("stock"));
			Double impuesto = Double.parseDouble(request.getParameter("impuesto").replace(",", "."));
			
			// Editar el objeto de la bbdd.
			
			String baja = request.getParameter("baja_producto");
			boolean bajaFlag = false;
			
			if (!baja.isEmpty()) {
				bajaFlag = true;
			}
			
			Producto producto = new Producto();
			
			producto.setNombre(nombre);
			producto.setDescripcion(descripcion);
			producto.setCategoria(categoria);
			producto.setPrecio(precio);
			producto.setStock(stock);
			producto.setImpuesto(impuesto);
			producto.setBaja(bajaFlag);
			
			int productoId = new ProductoDAOImpl().addProducto(producto);
			
			request.getRequestDispatcher("producto_mostrar").forward(request, response);
			
		
	}

}
