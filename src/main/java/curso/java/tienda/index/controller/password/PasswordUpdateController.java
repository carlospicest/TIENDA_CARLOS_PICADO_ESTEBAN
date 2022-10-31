package curso.java.tienda.index.controller.password;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HashCrypt;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import curso.java.tienda.index.dao.UsuarioDAOImpl;
import curso.java.tienda.index.pojo.Usuario;
import curso.java.tienda.index.service.PasswordUpdateService;
import mapping.Request;
import mapping.WebPath;

/**
 * Servlet implementation class PasswordUpdateController
 */
@WebServlet("/password_update")
public class PasswordUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PasswordUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario user = (Usuario) request.getSession().getAttribute("userdata");

		if (user != null) {

			Usuario userDb = new UsuarioDAOImpl().getUsuario(user.getEmail());
			
			String currentPassword = request.getParameter("current_password");
			String currentPasswordRepeat = request.getParameter("current_password_repeat");
			String password = request.getParameter("password");

			// Primero comprobamos si las contraseñas actuales son iguales.

			if (PasswordUpdateService.ifPasswordEquals(currentPassword, currentPasswordRepeat)) {
				
				// Verificamos que la contraseña actual proporcionada es correcta.
				
				if (PasswordUpdateService.isValidPassowrd(userDb, currentPassword)) {
					
					userDb = PasswordUpdateService.setNewPassword(userDb, password);
					
					boolean updateUser = new UsuarioDAOImpl().updateUsuario(userDb);
					
					ObjectMapper mapper = new ObjectMapper();
					ObjectNode updatePasswordInformation = mapper.createObjectNode();
					String json = null;

					if (updateUser) {
						
						updatePasswordInformation.put("result", Request.result.SUCCESS.toString());

						StringBuilder summaryStr = new StringBuilder();
						summaryStr.append("<h2 class=\"text-center\">Se ha actualizado la contraseña</h2>");
						summaryStr.append("<p class=\"h4 mt-5\">Ha cambiado la contraseña de su cuenta correctamente.</p>");

						updatePasswordInformation.put("msg", summaryStr.toString());

						json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(updatePasswordInformation);

					} else {

						updatePasswordInformation.put("result", Request.result.ERROR.toString());

						StringBuilder summaryStr = new StringBuilder();
						summaryStr.append("<h2 class=\"text-center\">No se ha actualizado la contraseña</h2>");
						summaryStr.append("<p class=\"h4 mt-5\">Se ha producido un error al intentar cambiar la contraseña de su cuenta.</p>");
						summaryStr.append("<p class=\"h4 mt-5\">Intente de nuevo más tarde, si el problema persiste, póngase en contacto con el administrador.</p>");

						updatePasswordInformation.put("msg", summaryStr.toString());

						json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(updatePasswordInformation);

					}

					request.setAttribute("resultado", json);
					request.getRequestDispatcher(WebPath.URL.RESULTADO.toString()).forward(request, response);
					
					
				} else {
					
					request.setAttribute("errorChangePassword", "La contraseña actual introducida no es válida");
					request.getRequestDispatcher("index/modificar_password.jsp").forward(request, response);
										
				}
				
				
				
			} else {
				
				request.setAttribute("errorChangePassword", "La contraseña actual y su repetición no son iguales.");
				request.getRequestDispatcher("index/modificar_password.jsp").forward(request, response);
				
			}
		
		}

	}

}
