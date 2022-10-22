package curso.java.tienda.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

	private int id;
	private int id_usuario;
	private long fecha;
	private String metodo_pago;
	private String estado;
	private String num_factura;
	private double total;
	
}
