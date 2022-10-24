package curso.java.tienda.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "detalles_carrito")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleCarrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "productos_id")
	private Producto producto;
	
	@Column(name = "unidades")
	private int unidades;
	@Column(name = "precio_unidad")
	private float precio_unidad;
	@Column(name = "impuesto")
	private float impuesto;
	
}
