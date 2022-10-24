package curso.java.tienda.index.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import curso.java.tienda.index.dao.ProductoDAOImpl;
import curso.java.tienda.index.pojo.DetalleCarrito;
import curso.java.tienda.index.pojo.Producto;

public class CarritoService {

	public static String getJSONCarrito(ArrayList<DetalleCarrito> cart) {
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode cartInformation = mapper.createObjectNode();
		
		// Primero obtenemos la cantidad de productos del carrito.
		
		ArrayNode productCartList = mapper.createArrayNode();
		
		productCartList.forEach((productCart) -> {
            productCartList.addPOJO(productCart);
        });
		
		cartInformation.set("product_list", productCartList);
		
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cartInformation);
		} catch (JsonProcessingException e) {
			System.err.println(e.getMessage());
		}
		
		return null;
		
	}
	
	public static String addProductCartSession(int idProd, int stack, HashMap<Integer, DetalleCarrito> cartList) {
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode addCartInformation = mapper.createObjectNode();
		
		Producto product = new ProductoDAOImpl().getProducto(idProd);
		
		if (product != null) {
			
			// Comprobamos si el producto ya ha sido agregado al carrito.
			
			DetalleCarrito cartDetail = cartList.get(idProd);
			
			if (cartDetail != null) {
				
				// Ya existe el producto, le incrementamos las unidades.
				
				int stackAux = cartDetail.getUnidades();
				
				stackAux += stack;
				
				cartDetail.setUnidades(stackAux);
				
				addCartInformation.put("result", true);
				
			} else {
				
				// No existe, lo agregamos.
				
				cartDetail = new DetalleCarrito();
				
				cartDetail.setProducto(product);
				cartDetail.setUnidades(stack);
				cartDetail.setPrecio_unidad(product.getPrecio());
				cartDetail.setImpuesto(product.getImpuesto());
				
				cartList.put(product.getId(), cartDetail);
				
				addCartInformation.put("result", true);
				
			}
			
		}
		
		// Agregar por último un sumario con los artículos, cantidad, precio de cada detalleCarrito.
		
		ArrayNode productCartList = mapper.createArrayNode();
		
		for (DetalleCarrito detail : cartList.values()) {
			productCartList.addPOJO(detail);
		}
		
		addCartInformation.set("products", productCartList);
		
		// Extraemos el número de productos en total del carrito.
		
		int totalProduct = getStackCountDetalleCarrito(cartList);
		
		addCartInformation.put("totalProduct", totalProduct);
		
		// Extraemos el precio total de los artículos del carrito.
		
		double totalAmmount = getTotalStackAmmountDetalleCarrito(cartList);
		
		addCartInformation.put("totalAmmount", totalAmmount);
		
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(addCartInformation);
		} catch (JsonProcessingException e) {
			// Traza
			return null;
		}
	
	}
	
	private static double getTotalStackAmmountDetalleCarrito(HashMap<Integer, DetalleCarrito> cart) {
		
		double totalAmmount = 0;
		
		for (DetalleCarrito product : cart.values()) {
			totalAmmount += (product.getPrecio_unidad()*product.getUnidades());
		}
		
		return totalAmmount;
		
		
	}
	
	private static int getStackCountDetalleCarrito(HashMap<Integer, DetalleCarrito> cart) {
		
		int totalProducts = 0;
		
		for (DetalleCarrito product : cart.values()) {
			totalProducts += product.getUnidades();
		}
				
		return totalProducts;
		
	}
	
}
