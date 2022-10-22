package curso.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import curso.java.tienda.bd.Conexion;
import curso.java.tienda.pojo.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {

	@Override
	public ArrayList<Categoria> getCategorias() {
		
		ArrayList<Categoria> listaCategorias = new ArrayList<>();
		
		Connection conexion = Conexion.getConexion();

		if (conexion != null) {

			try {

				String sql = "SELECT * FROM categorias";

				PreparedStatement ps = conexion.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					
					Categoria categoria = new Categoria();
					categoria.setId(rs.getInt("id"));
					categoria.setNombre(rs.getString("nombre"));
					categoria.setDescripcion(rs.getString("descripcion"));
					
					listaCategorias.add(categoria);
					
				}

				Conexion.desconectar();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getClass() + " => " + e.getMessage());
			}
			
		}
		
		
		return listaCategorias;
		
	}

}
