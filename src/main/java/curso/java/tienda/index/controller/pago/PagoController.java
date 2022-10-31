package curso.java.tienda.index.controller.pago;

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

import curso.java.tienda.index.dao.MetodoPagoDAOImpl;
import curso.java.tienda.index.pojo.DetallePedido;
import curso.java.tienda.index.pojo.MetodoPago;
import curso.java.tienda.index.pojo.Usuario;
import curso.java.tienda.index.service.CarritoService;
import mapping.Request;
import mapping.WebPath;

/**
 * Servlet implementation class PagoController
 */
@WebServlet("/pago")
public class PagoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PagoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Verificación de sesión de usuario en un filtro.

		Usuario user;
		String jsonResult;

		user = (Usuario) request.getSession().getAttribute("userdata");

		if (user == null) {

			ObjectMapper mapper = new ObjectMapper();
			ObjectNode pagoInformation = mapper.createObjectNode();

			pagoInformation.put("result", Request.result.USER_IDENTIFICATION_NEEDED.toString());

			StringBuilder summaryStr = new StringBuilder();
			summaryStr.append("<h2 class=\"text-center\">Upsss, hemos detectado que no está identificado...</h2>");
			summaryStr.append(
					"<p class='h4 mt-5'>Para poder finalizar el proceso de compra es necesario que se identifique.</p>");
			summaryStr.append(
					"<p class='h4 mt-5'>Si no dispone de una cuenta, puede <a href='registro'>crear</a> una nueva o <a href='login'>iniciar sesión</a> si ya dispone de una.</p>");

			pagoInformation.put("msg", summaryStr.toString());

			jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pagoInformation);


			request.setAttribute("resultado", jsonResult);
			request.getRequestDispatcher("WEB-INF/resultado/index.jsp").forward(request, response);

		} else {
			
			HashMap<Integer, DetallePedido> cart = (HashMap<Integer, DetallePedido>) request.getSession().getAttribute("cart");
			
			final double IVA = 21;
			double iva_operate = IVA/100;
			double totalPrice_WihtoutIVA = CarritoService.getTotalStackAmmountDetalleCarrito(cart);
			double totalPrice_IVA = totalPrice_WihtoutIVA*iva_operate;
			double totalPrice = totalPrice_WihtoutIVA + totalPrice_IVA;
			
			DecimalFormat df = new DecimalFormat("#,###.##");
			df.setRoundingMode(RoundingMode.FLOOR);
			
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode paymentDetails = mapper.createObjectNode();
			
			paymentDetails.put("IVA_tax", IVA);
			paymentDetails.put("total", df.format(totalPrice));
			paymentDetails.put("total_without_IVA", df.format(totalPrice_WihtoutIVA));
			paymentDetails.put("total_with_IVA", df.format(totalPrice_IVA));
			
			HashMap<Integer, MetodoPago> metodoPago = new MetodoPagoDAOImpl().getMetodoPago();
			
			request.setAttribute("paymentMethods", metodoPago);
			request.setAttribute("paymentDetails", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(paymentDetails));			
			request.getRequestDispatcher("index/pago.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
