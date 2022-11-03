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
 * Servlet implementation class ProductoUpdateController
 */
@WebServlet("/producto_actualizar")
public class ProductoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idProducto = Integer.parseInt(request.getParameter("producto"));
		Producto producto = new ProductoDAOImpl().getProducto(idProducto);
		ArrayList<Categoria> categoriaList = new CategoriaDAOImpl().getCategorias();
		
		request.setAttribute("categoriaList", categoriaList);
		request.setAttribute("producto", producto);
		request.getRequestDispatcher("dashboard/producto/actualizar_producto.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idProd = Integer.parseInt(request.getParameter("id"));
		
		Producto producto = new ProductoDAOImpl().getProducto(idProd);
		Categoria categoria = null;
		if (producto != null) {
			
			// Obtenemos parámetros del formulario.
			
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			Integer categoriaId = Integer.parseInt(request.getParameter("categoria"));
			categoria = new CategoriaDAOImpl().getCategoria(categoriaId);
			Double precio = Double.parseDouble(request.getParameter("precio").replace(",", "."));
			Integer stock = Integer.parseInt(request.getParameter("stock"));
			Double impuesto = Double.parseDouble(request.getParameter("impuesto").replace(",", "."));
			
			String baja = request.getParameter("baja_producto");
			boolean bajaFlag = false;
			
			if (!baja.isEmpty()) {
				bajaFlag = true;
			}
			
			
			producto.setNombre(nombre);
			producto.setDescripcion(descripcion);
			producto.setCategoria(categoria);
			producto.setPrecio(precio);
			producto.setStock(stock);
			producto.setImpuesto(impuesto);
			producto.setBaja(bajaFlag);
			
			boolean resultado = new ProductoDAOImpl().updateProducto(producto);
			
			request.getRequestDispatcher("producto_mostrar").forward(request, response);
			
		}
		
		
	}

}
