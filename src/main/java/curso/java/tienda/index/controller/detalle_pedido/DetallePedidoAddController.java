package curso.java.tienda.index.controller.detalle_pedido;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import curso.java.tienda.index.dao.DetallePedidoDAOImpl;
import curso.java.tienda.index.dao.PedidoDAOImpl;
import curso.java.tienda.index.pojo.DetallePedido;
import curso.java.tienda.index.pojo.Pedido;
import curso.java.tienda.index.pojo.Usuario;
import curso.java.tienda.index.service.CarritoService;
import curso.java.tienda.util.DateTime;
import datos.EstadoPedido;
import mapping.Request;
import mapping.WebPath;

/**
 * Servlet implementation class DetallePedidoAddController
 */
@WebServlet("/checkout")
public class DetallePedidoAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetallePedidoAddController() {
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

		String paymentMethod = request.getParameter("paymentMethod");

		Usuario user = (Usuario) request.getSession().getAttribute("userdata");

		// Agregar detalle pedido a la base de datos.

		HashMap<Integer, DetallePedido> cart = (HashMap<Integer, DetallePedido>) request.getSession()
				.getAttribute("cart");


		// Creamos el pedido para registrarlo.

		DecimalFormat df = new DecimalFormat("#,###.##");
		df.setRoundingMode(RoundingMode.FLOOR);

		Pedido pedido = new Pedido();

		pedido.setUsuario(user);
		pedido.setFecha(DateTime.getCurrentTime());
		pedido.setMetodo_pago(paymentMethod);
		pedido.setEstado(EstadoPedido.estado.PENDIENTE_ENVIO.toString());
		pedido.setNum_factura("A0");
		pedido.setTotal(CarritoService.getTotalStackAmmountDetalleCarrito(cart));

		new PedidoDAOImpl().addPedido(pedido);
		
		// Variables de validación.

		int productsCount = cart.size();
		int productsProcessed = 0;

		// Agregamos en detalles_pedido cada uno de los artículos del carrito.

		for (DetallePedido detallePedido : cart.values()) {
			detallePedido.setPedido(pedido);
			if (new DetallePedidoDAOImpl().addDetallePedido(detallePedido) > -1) {
				productsProcessed++;
			}
		}

		// Comprobamos si se han procesado todos los productos del carrito.

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode detallePedidoInformation = mapper.createObjectNode();

		if (productsProcessed == productsCount) {

			// Enviamos confirmación de que el pedido se ha realizado correctamente al
			// usuario.

			detallePedidoInformation.put("result", Request.result.SUCCESS.toString());

			StringBuilder summaryStr = new StringBuilder();
			summaryStr.append("<h2 class=\"text-center\">Se ha registrado su pedido correctamente</h2>");
			summaryStr.append("<p class=\"h4 mt-5\">Hemos recibido su solicitud de pedido.</p>");
			summaryStr.append(
					"<p class=\"h4 mt-5\">En breve, nuestros agentes comenzarán a preparar su pedido para que lo reciba lo antes posible.</p>");
			summaryStr.append(
					"<p class=\"h4 mt-5\">Podrá ver el seguimiento del pedido desde el historial de pedidos.</p>");
			summaryStr.append("<p class=\"h4 mt-5\">Gracias por confiar en nuestra tienda.</p>");

			detallePedidoInformation.put("msg", summaryStr.toString());

			// Vaciamos el carrito de la sesión del usuario.

			cart.clear();

		} else {

			// Informamos de que algunos productos no han podido ser procesados.

			detallePedidoInformation.put("result", Request.result.ERROR.toString());

			StringBuilder summaryStr = new StringBuilder();
			summaryStr.append("<h2 class=\"text-center\">Se han producido problemas en su pedido</h2>");
			summaryStr
					.append("<p class=\"h4 mt-5\">Hemos detectado inconvenientes que impiden tramitar su pedido.</p>");
			summaryStr.append(
					"<p class=\"h4 mt-5\">Por favor, comuníquese con nuestros agentes facilitando el resguardo de factura.</p>");

		}

		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(detallePedidoInformation);

		request.setAttribute("resultado", json);
		request.getRequestDispatcher(WebPath.URL.RESULTADO.toString()).forward(request, response);

	}

}
