package datos;

public class EstadoPedido {

	public enum estado {

		PENDIENTE_ENVIO("PE"), PENDIENTE_CANCELACION("PC"), ENVIADO("E"), CANCELADO("C");

		private final String estado;

		estado(final String estado) {
			this.estado = estado;
		}

		public String toString() {
			return estado;
		}

	}

}
