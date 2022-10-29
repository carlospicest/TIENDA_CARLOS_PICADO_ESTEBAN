package datos;

public class RoleData {

	public enum rol {

		INVITADO(1),
		CLIENTE(2),
		ADMINISTRADOR(3);

		private final int id;

		rol(final int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

	}

}
