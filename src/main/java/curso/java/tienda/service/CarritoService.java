package curso.java.tienda.service;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import curso.java.tienda.pojo.Carrito;

public class CarritoService {

	public static String getJSONCarrito(ArrayList<Carrito> cart) {
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode cartInformation = mapper.createObjectNode();
		
		// Primero obtenemos la cantidad de productos del carrito.
		
		ObjectNode cartSize = mapper.createObjectNode();
		cartSize.put("size", cart.size());
		
		
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cartInformation);
		} catch (JsonProcessingException e) {
			System.err.println(e.getMessage());
		}
		
		return null;
		
	}
	
}
