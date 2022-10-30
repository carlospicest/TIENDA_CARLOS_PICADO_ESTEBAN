package curso.java.tienda.index.controller.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import curso.java.tienda.index.dao.UsuarioDAOImpl;
import curso.java.tienda.index.pojo.Usuario;
import curso.java.tienda.index.service.LoginService;
import curso.java.tienda.index.service.UsuarioService;
import mapping.Request;
import mapping.WebPath;

/**
 * Servlet implementation class UsuarioUpdateController
 */
@WebServlet("/usuario_update")
public class UsuarioUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recogemos los parámetros enviados.
		
		String nombre = request.getParameter("nombre");
		String primerApellido = request.getParameter("primer_apellido");
		String segundoApellido = request.getParameter("segundo_apellido");
		String direccion = request.getParameter("direccion");
		String provincia = request.getParameter("provincia");
		String localidad = request.getParameter("localidad");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		Usuario user = new UsuarioDAOImpl().getUsuario(email);
		
		user.setNombre(nombre);
		user.setApellido1(primerApellido);
		user.setApellido2(segundoApellido);
		user.setDireccion(direccion);
		user.setProvincia(provincia);
		user.setLocalidad(localidad);
		user.setTelefono(telefono);
		user.setEmail(email);
		
		boolean updateResult = new UsuarioDAOImpl().updateUsuario(user);
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode userUpdateProfile = mapper.createObjectNode();
		
		// Si los cambios se han guardado, refrescamos el parámetro del usuario de la sesión.
		
		if (updateResult) {
			
			Usuario userProtected = UsuarioService.getUsuarioMixin(user);
			
			userUpdateProfile.put("result", Request.result.SUCCESS.toString());
			
			StringBuilder summaryStr = new StringBuilder();
			summaryStr.append("<h2 class=\"text-center\">Se han actualizado sus datos</h2>");
			summaryStr.append("<p class=\"h4 mt-5\">Los cambios en su perfil de usuario se han guardado correctamente.</p>");
			
			userUpdateProfile.put("msg", summaryStr.toString());
			
			request.getSession().setAttribute("userdata", userProtected);
			
		} else {
			
			userUpdateProfile.put("result", Request.result.ERROR.toString());
			
			StringBuilder summaryStr = new StringBuilder();
			summaryStr.append("<h2 class=\"text-center\">Error al actualizar información</h2>");
			summaryStr.append("<p class=\"h4 mt-5\">Se ha producido un error que ha impedido modificar la información de usuario.</p>");
			summaryStr.append("<p class=\"h4 mt-5\">Intente más tarde y en caso de que el problema persista, póngase en contacto con el administrador.</p>");
			userUpdateProfile.put("msg", summaryStr.toString());
			
		}
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userUpdateProfile);
		
		request.setAttribute("resultado", json);
		request.getRequestDispatcher(WebPath.URL.RESULTADO.toString()).forward(request, response);
		
	}

}
