package curso.java.tienda.index.service;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import curso.java.tienda.index.dao.ProductoDAOImpl;
import curso.java.tienda.index.pojo.DetallePedido;
import curso.java.tienda.index.pojo.Producto;

public class CarritoService {

	public static String getProductCart(HashMap<Integer, DetallePedido> cartList) {
		
		return getJSONCartInfo(cartList);
		
	}
	
	public static String addProductCart(int idProd, int stack, HashMap<Integer, DetallePedido> cartList) {

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode addCartInformation = mapper.createObjectNode();

		Producto product = new ProductoDAOImpl().getProducto(idProd);

		if (product != null) {

			// Comprobamos si el producto ya ha sido agregado al carrito.

			DetallePedido cartDetail = cartList.get(idProd);

			if (cartDetail != null) {

				// Ya existe el producto, le incrementamos las unidades.

				int stackAux = cartDetail.getUnidades();

				stackAux += stack;

				cartDetail.setUnidades(stackAux);

			} else {

				// No existe, lo agregamos.

				cartDetail = new DetallePedido();

				cartDetail.setProducto(product);
				cartDetail.setUnidades(stack);
				cartDetail.setPrecio_unidad(product.getPrecio());
				cartDetail.setImpuesto(product.getImpuesto());

				cartList.put(product.getId(), cartDetail);

			}

		}

		return getJSONCartInfo(cartList);
		
	}

	private static String getJSONCartInfo(HashMap<Integer, DetallePedido> cart) {

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode cartInformation = mapper.createObjectNode();

		// Extraemos el número de productos en total del carrito.

		int totalProduct = getStackCountDetalleCarrito(cart);

		cartInformation.put("totalProduct", totalProduct);

		// Agregamos los productos que existen en el carrito.
		
		ArrayNode productCartList = mapper.createArrayNode();

		for (DetallePedido detail : cart.values()) {
			productCartList.addPOJO(detail);
		}

		cartInformation.set("products", productCartList);

		// Extraemos el precio total de los artículos del carrito.

		double totalAmmount = getTotalStackAmmountDetalleCarrito(cart);

		cartInformation.put("totalAmmount", totalAmmount);

		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cartInformation);
		} catch (JsonProcessingException e) {
			// Traza
			return null;
		}

	}

	private static double getTotalStackAmmountDetalleCarrito(HashMap<Integer, DetallePedido> cart) {

		double totalAmmount = 0;

		if (cart != null && !cart.isEmpty()) {

			for (DetallePedido product : cart.values()) {
				totalAmmount += (product.getPrecio_unidad() * product.getUnidades());
			}

		}

		return totalAmmount;

	}

	private static int getStackCountDetalleCarrito(HashMap<Integer, DetallePedido> cart) {

		int totalProducts = 0;

		if (cart != null && !cart.isEmpty()) {

			for (DetallePedido product : cart.values()) {
				totalProducts += product.getUnidades();
			}

		}

		return totalProducts;

	}

}
