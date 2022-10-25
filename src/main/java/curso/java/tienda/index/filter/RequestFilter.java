package curso.java.tienda.index.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import curso.java.tienda.index.dao.CarritoDAOImpl;
import curso.java.tienda.index.dao.CategoriaDAOImpl;
import curso.java.tienda.index.dao.DetalleCarritoDAOImpl;
import curso.java.tienda.index.dao.ProductoDAOImpl;
import curso.java.tienda.index.pojo.Carrito;
import curso.java.tienda.index.pojo.Categoria;
import curso.java.tienda.index.pojo.DetalleCarrito;
import curso.java.tienda.index.pojo.Producto;
import curso.java.tienda.index.pojo.Usuario;

/**
 * Servlet Filter implementation class RequestFilter
 */
@WebFilter("/*")
public class RequestFilter extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public RequestFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		/*
		 * Este filtro servirá como fuente para obtener los datos que serán utilizados
		 * en las distintas vistas de la tienda.
		 */

		// Obtener categorias.

		ArrayList<Categoria> categoriasList = new CategoriaDAOImpl().getCategorias();
		request.setAttribute("categoriasList", categoriasList);

		// Obtener productos.

		ArrayList<Producto> productosList = new ProductoDAOImpl().getProductos();
		request.setAttribute("productosList", productosList);

		// Generar atributos de sesión si no los tiene (Carrito).

		Usuario user = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("userdata");

		// El carrito en sesión lo generamos si está vacío y no hay un usuario logueado.

		if (user == null) {

			HashMap<Integer, DetalleCarrito> cartList = (HashMap<Integer, DetalleCarrito>) ((HttpServletRequest) request)
					.getSession().getAttribute("cart");

			// Inicializamos el carrito si no existe y lo almacenamos en la sesión.
			if (cartList == null) {
				cartList = new HashMap<Integer, DetalleCarrito>();
				((HttpServletRequest) request).getSession().setAttribute("cart", cartList);
			}

			// Para poder usarlo en otros controladores y/o vistas.

			((HttpServletRequest) request).setAttribute("cart", cartList);

		} else {

			// El usuario está logueado, comprobamos si tiene artículos en el carrito de sesión,

			HashMap<Integer, DetalleCarrito> cartList = (HashMap<Integer, DetalleCarrito>) ((HttpServletRequest) request)
					.getSession().getAttribute("cart");

			if (cartList != null && !cartList.isEmpty()) {

				// Tiene artículos en el carrito de la sesión, los pasamos a persistir en bbdd.
				
				// Generamos el carrito para el usuario.

				Carrito cart = new Carrito();
				cart.setCheckout(false);
				cart.setUsuario(user);

				int cartID = new CarritoDAOImpl().addCarrito(cart);

				// Si se ha generado el carrito, comenzamos a introducir sus productos.

				if (cartID > -1) {

					for (DetalleCarrito product : cartList.values()) {

						DetalleCarrito productDetail = new DetalleCarrito();
						productDetail.setCarrito(cart);
						productDetail.setImpuesto(product.getImpuesto());
						productDetail.setUnidades(product.getUnidades());
						productDetail.setPrecio_unidad(product.getPrecio_unidad());
						productDetail.setProducto(product.getProducto());

						new DetalleCarritoDAOImpl().addDetalleCarrito(productDetail);

					}

					// Una vez incorporados los artículos, limpiamos el atributo cart de la sesión.

					((HttpServletRequest) request).getSession().setAttribute("cart", null);

				}

			} else {
				
				// Obtenemos los artículos del carrito que tiene en la bbdd.
				
				Carrito cart = new CarritoDAOImpl().getCarritoUnproccessed(user);
				
				HashMap<Integer, DetalleCarrito> cartList = new DetalleCarritoDAOImpl().getDetalleCarrito(0);
				
			}

		}

		// pass the request along the filter chain
		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
