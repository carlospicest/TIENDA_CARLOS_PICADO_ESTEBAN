package curso.java.tienda.index.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DetallePedido {
	
	private int id;
	private int id_pedido;
	private int id_producto;
	private int unidades;
	private float precio_unidad;
	private float impuesto;
	private double total;

}
