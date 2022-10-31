package curso.java.tienda.index.service;

import com.HashCrypt;

import curso.java.tienda.index.pojo.Usuario;

public class PasswordUpdateService {

	public static boolean ifPasswordEquals(String password1, String password2) {
		
		return password1.equals(password2);
		
	}
	
	public static boolean isValidPassowrd(Usuario user, String password) {
		
		String currentSalt = user.getSalt();
		String currentPassword = user.getPassword();
		String currentPasswordAux = user.getEmail() + password; // La pw proporcionada en el formulario.
		
		return HashCrypt.isSame(currentSalt, currentPassword, currentPasswordAux);
		
	}
	
	public static Usuario setNewPassword(Usuario user, String password) {
		
		String salt = HashCrypt.generateSalt(32);
		String passwordChanged = HashCrypt.generateHash(salt, user.getEmail() + password);
		
		user.setSalt(salt);
		user.setPassword(passwordChanged);
		
		return user;
		
	}
	
}
