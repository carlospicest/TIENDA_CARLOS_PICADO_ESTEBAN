package curso.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import curso.java.tienda.pojo.Producto;
import curso.java.tienda.util.Conexion;
import curso.java.tienda.util.Util;

public class ProductoDAOImpl implements ProductoDAO {

	@Override
	public ArrayList<Producto> getProductos() {
		
		ArrayList<Producto> listaProductos = new ArrayList<>();
		
		Connection conexion = Conexion.getConexion();

		if (conexion != null) {

			try {

				String sql = "SELECT * FROM productos";

				PreparedStatement ps = conexion.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					
					Producto producto = new Producto();
					producto.setId(rs.getInt("id"));
					producto.setId_categoria(rs.getInt("id_categoria"));
					producto.setNombre(rs.getString("nombre"));
					producto.setDescripcion(rs.getString("descripcion"));
					producto.setPrecio(rs.getDouble("precio"));
					producto.setStock(rs.getInt("stock"));
					producto.setImpuesto(rs.getFloat("impuesto"));
					producto.setImagen(rs.getString("imagen"));
					producto.setBaja(Util.intToBoolean(rs.getInt("baja")));
					producto.setFecha_alta(rs.getLong("fecha_alta"));
					
					listaProductos.add(producto);
					
				}

				Conexion.desconectar();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getClass() + " => " + e.getMessage());
			}
			
		}
		
		return listaProductos;
		
	}

}
