package curso.java.tienda.index.filter;

import java.io.IOException;
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

import curso.java.tienda.index.pojo.DetallePedido;

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

		HashMap<Integer, DetallePedido> cartList = (HashMap<Integer, DetallePedido>) ((HttpServletRequest) request)
				.getSession().getAttribute("cart");

		// Inicializamos el carrito si no existe y lo almacenamos en la sesión.
		if (cartList == null) {
			cartList = new HashMap<Integer, DetallePedido>();
			((HttpServletRequest) request).getSession().setAttribute("cart", cartList);
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
