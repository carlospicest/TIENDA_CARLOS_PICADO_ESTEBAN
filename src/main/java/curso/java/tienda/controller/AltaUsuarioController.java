package curso.java.tienda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		ArrayList<String> datosFormulario = new ArrayList<>(
								                Arrays.asList(request.getParameter("nombre"), 
								                			  request.getParameter("primer_apellido"),
								                			  request.getParameter("nombre"),
								                			  request.getParameter("primer_apellido"),
								                			  request.getParameter("segundo_apellido"),
								                			  request.getParameter("dni"),
								                			  request.getParameter("direccion"),
								                			  request.getParameter("provincia"),
								                			  request.getParameter("localidad"),
								                			  request.getParameter("telefono"),
								                			  request.getParameter("password"),
								                			  request.getParameter("repassword")));
		
	}

}
