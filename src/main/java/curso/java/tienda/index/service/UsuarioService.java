package curso.java.tienda.index.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import curso.java.tienda.index.pojo.Rol;
import curso.java.tienda.index.pojo.Usuario;
import curso.java.tienda.index.pojo.mixin.RolMixin;
import curso.java.tienda.index.pojo.mixin.UsuarioMixin;

public class UsuarioService {

	public static String getUserData(Usuario user) {
		
		String userDataJSON = null;
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.addMixIn(Rol.class, RolMixin.class);
		mapper.addMixIn(Usuario.class, UsuarioMixin.class);
		
		try {
			
			userDataJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
			
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
		}
		
		return userDataJSON;
		
	}
	
	
	/**
	 * Devuelve un objeto al que se le ha aplicado una clase MixIn mediante Jackson.
	 * 
	 * Una clase MixInes un nuevo POJO que se basa sobre un POJO existente permitiendo aplicar 
	 * modificaciones a este sin afectar al POJO original.
	 * 
	 * En este caso, se emplea para ocultar información sensible, como por ejemplo:
	 * 	- Contraseña.
	 *  - Salt.
	 *  - Id del rol.
	 *  - Fecha de alta.
 	 * @param usuario
	 * @return
	 */
	
	public static Usuario getUsuarioMixin(Usuario usuario) {
		
		Usuario usuarioProtegido = null;
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.addMixIn(Usuario.class, UsuarioMixin.class);
		mapper.addMixIn(Rol.class, RolMixin.class);
		
		try {
			
			byte[] usuarioDataMixin = mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(usuario);
			
			usuarioProtegido = mapper.readValue(usuarioDataMixin, Usuario.class);
			
			System.out.println("");
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarioProtegido;
		
	}
	
}
