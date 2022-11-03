package curso.java.tienda.index.dao;

import java.util.ArrayList;

import curso.java.tienda.index.pojo.Categoria;

public interface CategoriaDAO {

	public ArrayList<Categoria> getCategorias();
	
	public Categoria getCategoria(int id);
	
}
