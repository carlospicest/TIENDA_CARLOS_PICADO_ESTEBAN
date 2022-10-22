package curso.java.tienda.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	private int id;
	private int id_categoria;
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	private float impuesto;
	private String imagen;
	private boolean baja;
	private long fecha_alta;
	
}
