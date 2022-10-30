package curso.java.tienda.index.service;

import java.io.IOException;

import com.HashCrypt;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import curso.java.tienda.index.dao.UsuarioDAOImpl;
import curso.java.tienda.index.pojo.Rol;
import curso.java.tienda.index.pojo.Usuario;
import curso.java.tienda.index.pojo.mixin.RolMixin;
import curso.java.tienda.index.pojo.mixin.UsuarioMixin;

public class LoginService {

	/**
	 * Comprueba los campos de email y password recibidos por formulario.
	 * 
	 * Si los datos son correctos, se devuelve un objeto de tipo Usuario pero sin la
	 * información sensible del usuario.
	 * 
	 * @param email
	 * @param password
	 * @return
	 */

	public static Usuario validarCredenciales(String email, String password) {

		Usuario user = new UsuarioDAOImpl().getUsuario(email);

		if (user != null) {

			String saltStored = user.getSalt();
			String passwordStored = user.getPassword();

			if (HashCrypt.isSame(saltStored, passwordStored, email + password)) {
				
				user = UsuarioService.getUsuarioMixin(user);
				
				return user; // Credenciales correcta.
			} else {
				return null; // Credenciales incorrectas.
			}

		}

		return null; // El usuario no existe.

	}

}
