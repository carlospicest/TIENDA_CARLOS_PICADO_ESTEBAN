package curso.java.tienda.index.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import mapping.Request;

public class CancelacionPedidoService {

	public static String getJSONResult(boolean result) {

		String json = null;

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode addCancelacionPedido = mapper.createObjectNode();

		try {

			if (result) {

				addCancelacionPedido.put("result", Request.result.SUCCESS.toString());

				StringBuilder summaryStr = new StringBuilder();
				summaryStr.append("<h2 class=\"text-center\">Se ha registrado su cancelación de pedido</h2>");
				summaryStr.append(
						"<p class=\"h4 mt-5\">Hemos recibido correctamente su petición de cancelación de pedido.</p>");
				summaryStr.append(
						"<p class=\"h4 mt-5\">Nuestros agentes evualuarán su solicitud a la mayor brevedad.</p>");

				addCancelacionPedido.put("msg", summaryStr.toString());

				json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(addCancelacionPedido);

			} else {

				addCancelacionPedido.put("result", Request.result.ERROR.toString());

				StringBuilder summaryStr = new StringBuilder();
				summaryStr.append("<h2 class=\"text-center\">Error al registrar su cancelación de pedido</h2>");
				summaryStr.append(
						"<p class=\"h4 mt-5\">Se ha producido un error al registrar su solicitud de cancelación de pedido.</p>");
				summaryStr.append(
						"<p class=\"h4 mt-5\">Si sigue recibiendo errores de nuevo, póngase en contacto con un agente.</p>");

				addCancelacionPedido.put("msg", summaryStr.toString());

				json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(addCancelacionPedido);

			}

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;

	}

}
