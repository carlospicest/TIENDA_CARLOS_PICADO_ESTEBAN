package curso.java.tienda.service;

import com.HashCrypt;

import curso.java.tienda.dao.UsuarioDAOImpl;
import curso.java.tienda.pojo.Usuario;

public class LoginService {

	/**
	 * Comprueba los campos de email y password recibidos por formulario.
	 * 
	 * Si los datos son correctos, se devuelve un objeto de tipo Usuario pero
	 * sin la información sensible del usuario.
	 * @param email
	 * @param password
	 * @return
	 */
	
	public static Usuario validarCredenciales(String email, String password) {
		
		Usuario user = new UsuarioDAOImpl().getUsuario(email);
		
		if (user != null) {
			
			String saltStored = user.getSalt();
			String passwordStored = user.getPassword();
			
			if (HashCrypt.isSame(saltStored, passwordStored, email+password)) {
				
				user.setPassword(null);
				user.setSalt(null);
				
				return user; // Credenciales correcta.
				
			} else {
				return null; // Credenciales incorrectas.
			}
			
		}
		
		return null; // El usuario no existe.
		
	}
	
}
