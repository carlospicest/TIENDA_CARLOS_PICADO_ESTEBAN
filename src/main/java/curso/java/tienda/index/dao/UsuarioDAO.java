package curso.java.tienda.index.dao;

import java.util.ArrayList;

import curso.java.tienda.index.pojo.Usuario;

public interface UsuarioDAO {

	public int addUsuario(Usuario usuario);
	
	public ArrayList<Usuario> getUsuario();
	
	public Usuario getUsuario(int id);
	
	public Usuario getUsuario(String email);
	
	public boolean updateUsuario(Usuario usuario);
	
	public boolean deleteUsuario(Usuario usuario);
	
}
