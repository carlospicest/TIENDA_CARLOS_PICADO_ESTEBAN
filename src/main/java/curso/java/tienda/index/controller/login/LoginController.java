package curso.java.tienda.index.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.index.pojo.Usuario;
import curso.java.tienda.index.service.LoginService;
import curso.java.tienda.util.RoleDataUtil;
import mapping.WebPath;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(WebPath.URL.LOGIN_JSP.toString()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario user = null;
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if ((user = LoginService.validarCredenciales(email, password)) != null) {
			RoleDataUtil.setRol(user.getRol());
			request.getSession().setAttribute("userdata", user);
			request.getRequestDispatcher(WebPath.URL.INDEX_CONTROLLER.toString()).forward(request, response);
		} else {
			request.setAttribute("errorLogin", "Los datos introducidos no son correctos, por favor, intente de nuevo.");
			request.getRequestDispatcher(WebPath.URL.LOGIN_JSP.toString()).forward(request, response);
		}

	}

}
