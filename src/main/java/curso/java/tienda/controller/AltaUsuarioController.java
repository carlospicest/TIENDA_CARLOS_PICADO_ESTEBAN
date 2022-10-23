package curso.java.tienda.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import curso.java.tienda.dao.UsuarioDAOImpl;
import curso.java.tienda.pojo.Rol;
import curso.java.tienda.pojo.Usuario;
import curso.java.tienda.service.AltaUsuarioService;
import curso.java.tienda.util.DateTime;
import mapping.Request;
import mapping.WebPath;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/registro")
public class AltaUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(WebPath.URL.ALTA_USUARIO.toString()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtener información del formulario.
		
		/*ArrayList<String> datosFormulario = new ArrayList<>(
								                Arrays.asList(request.getParameter("nombre"),
								                			  request.getParameter("primer_apellido"),
								                			  request.getParameter("segundo_apellido"),
								                			  request.getParameter("dni"),
								                			  request.getParameter("direccion"),
								                			  request.getParameter("provincia"),
								                			  request.getParameter("localidad"),
								                			  request.getParameter("telefono"),
								                			  request.getParameter("password"),
								                			  request.getParameter("repassword")));*/
		
		// TODO: Implementar validación de datos.
		
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setApellido1(request.getParameter("primer_apellido"));
		usuario.setApellido2(request.getParameter("segundo_apellido"));
		usuario.setDni(request.getParameter("dni"));
		usuario.setDireccion(request.getParameter("direccion"));
		usuario.setProvincia(request.getParameter("provincia"));
		usuario.setLocalidad(request.getParameter("localidad"));
		usuario.setTelefono(request.getParameter("telefono"));
		usuario.setPassword(request.getParameter("password"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setFecha_alta(DateTime.getCurrentTime());
		
		usuario = AltaUsuarioService.setEncriptacion(usuario);
				
		int idUsuario = new UsuarioDAOImpl().addUsuario(usuario);
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode altaInformacion = mapper.createObjectNode();
		
		if (idUsuario > -1) {
			
			altaInformacion.put("result", Request.result.SUCCESS.toString());
			
			StringBuilder summaryStr = new StringBuilder();
			summaryStr.append("<h2 class=\"text-center\">Se ha registrado correctamente</h2>");
			summaryStr.append("<p class=\"h4 mt-5\">Ahora podrá disfrutar de todas las ventajas de nuestra tienda.</p>");
			summaryStr.append("<p class=\"h4 mt-5\">Inicie sesión para acceder a todas nuestras ofertas.</p>");
			
			altaInformacion.put("msg", summaryStr.toString());
			
		} else {
			
			altaInformacion.put("result", Request.result.ERROR.toString());
			
			StringBuilder summaryStr = new StringBuilder();
			summaryStr.append("<h2 class=\"text-center\">Se ha producido un error en el registro</h2>");
			summaryStr.append("<p class=\"h4 mt-5\">No se ha podido completar la creación de su cuenta, intente en otro momento.</p>");
			
			altaInformacion.put("msg", summaryStr.toString());
			
		}
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(altaInformacion);
		
		request.setAttribute("resultado", json);
		request.getRequestDispatcher(WebPath.URL.RESULTADO.toString()).forward(request, response);
		
	}

}
