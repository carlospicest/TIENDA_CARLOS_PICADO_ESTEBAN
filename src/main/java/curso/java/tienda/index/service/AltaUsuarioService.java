package curso.java.tienda.index.service;

import com.HashCrypt;

import curso.java.tienda.index.pojo.Usuario;

public class AltaUsuarioService {

	public static Usuario setEncriptacion(Usuario usuario) {

		String salt = HashCrypt.generateSalt(32);

		String password = HashCrypt.generateHash(salt, usuario.getEmail() + usuario.getPassword());

		// Establecemos la password encriptada (email+password) en el usuario con su
		// respectiva salt.

		usuario.setSalt(salt);
		usuario.setPassword(password);

		return usuario;

	}

}
