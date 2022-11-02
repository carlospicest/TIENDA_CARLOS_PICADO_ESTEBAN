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

import curso.java.tienda.index.dao.OpcionMenuDAOImpl;
import curso.java.tienda.index.dao.RolDAOImpl;
import curso.java.tienda.index.pojo.DetallePedido;
import curso.java.tienda.index.pojo.OpcionMenu;
import curso.java.tienda.index.pojo.Rol;
import curso.java.tienda.index.pojo.Usuario;
import datos.RoleData;

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

		// Comprobamos si el usuario tiene una sesión o es anónimo.
		
		Usuario user = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("userdata");
		Rol rolUser = null;
		
		if (user == null) {
			rolUser = new RolDAOImpl().getRol(RoleData.rol.ANONIMO.getId());
		} else {
			rolUser = user.getRol();
		}
		
		// Comprobamos si las opciones del menú ya han sido cargadas.
		
		HashMap<String, OpcionMenu> menuOpciones = (HashMap<String, OpcionMenu>) ((HttpServletRequest) request).getSession().getAttribute("menuOpciones");
		
		if (menuOpciones == null) {
			
			//menuOpciones = new OpcionMenuDAO
			
		}
		
		((HttpServletRequest) request).getSession().setAttribute("rolUser", rolUser);
		
		HashMap<Integer, DetallePedido> cartList = (HashMap<Integer, DetallePedido>) ((HttpServletRequest) request)
				.getSession().getAttribute("cart");

		// Inicializamos el carrito si no existe y lo almacenamos en la sesión.
		if (cartList == null) {
			cartList = new HashMap<Integer, DetallePedido>();
			((HttpServletRequest) request).getSession().setAttribute("cart", cartList);
		}

		// Obtenemos las opciones del menú disponibles
		
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
