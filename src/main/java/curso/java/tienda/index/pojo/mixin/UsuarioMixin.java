package curso.java.tienda.index.pojo.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import curso.java.tienda.index.pojo.Usuario;

@JsonIgnoreProperties( { "password", "salt", "fecha_alta", "baja" })
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public abstract class UsuarioMixin extends Usuario {

	@JsonProperty private RolMixin rol;
	
}