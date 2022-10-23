package curso.java.tienda.service;

import com.HashCrypt;

import curso.java.tienda.dao.UsuarioDAOImpl;
import curso.java.tienda.pojo.Usuario;

public class LoginService {

	public static boolean validarCredenciales(String email, String password) {
		
		Usuario user = new UsuarioDAOImpl().getUsuario(email);
		
		if (user != null) {
			
			String saltStored = user.getSalt();
			String passwordStored = user.getPassword();
			
			return HashCrypt.isSame(saltStored, passwordStored, email+password);
			
		}
		
		return false;
		
	}
	
}
