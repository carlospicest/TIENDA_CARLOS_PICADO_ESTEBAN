package curso.java.tienda.index.controller.cancelacion_pedido;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.index.dao.CancelacionPedidoDAOImpl;
import curso.java.tienda.index.dao.PedidoDAOImpl;
import curso.java.tienda.index.pojo.CancelacionPedido;
import curso.java.tienda.index.pojo.Pedido;
import curso.java.tienda.index.pojo.Usuario;
import curso.java.tienda.index.service.CancelacionPedidoService;
import datos.EstadoCancelacionPedido;
import datos.EstadoPedido;
import mapping.Request;
import mapping.WebPath;

/**
 * Servlet implementation class CancelacionPedidoAddController
 */
@WebServlet("/cancelar_pedido")
public class CancelacionPedidoAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CancelacionPedidoAddController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario user = (Usuario) request.getSession().getAttribute("userdata");
		Integer idPedido = (Integer) request.getSession().getAttribute("pedidoCancelId");

		if (user != null && idPedido != null) {

			Pedido pedido = new PedidoDAOImpl().getPedido(idPedido);

			// Verificamos que el motivo no sea nulo.

			String motivo = request.getParameter("motivo");

			if (motivo != null && !motivo.isEmpty()) {

				if (pedido != null) {

					// Obtenemos la información del formulario.

					CancelacionPedido cancelacionPedido = new CancelacionPedido();
					cancelacionPedido.setPedido(pedido);
					cancelacionPedido.setMotivo(motivo);
					cancelacionPedido.setEstado(EstadoCancelacionPedido.estado.PENDIENTE_PROCESAR.toString());

					int idCancelacion = new CancelacionPedidoDAOImpl().addCancelacionPedido(cancelacionPedido);

					String jsonResult = null;
					
					// Devolvemos a la vista resultado y si se ha procesado correctamente la cancelación actualizamos el estado del pedido.
					
					if (idCancelacion > 0) {
						jsonResult = CancelacionPedidoService.getJSONResult(true);
						pedido.setEstado(EstadoPedido.estado.PENDIENTE_CANCELACION.toString());
						new PedidoDAOImpl().updatePedido(pedido);
					} else {
						jsonResult = CancelacionPedidoService.getJSONResult(false);
					}

					request.setAttribute("resultado", jsonResult);
					request.getRequestDispatcher(WebPath.URL.RESULTADO.toString()).forward(request, response);

				}

			}

		}

	}

}
