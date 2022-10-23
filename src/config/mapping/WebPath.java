package mapping;

public class WebPath {
	
	public enum URL {
		
		// Parte P�blica.
		
	    INDEX("index/index.jsp"),
	    LOGIN("index/login.jsp"),
	    ALTA_USUARIO("index/alta_usuario/alta_usuario.jsp"),
	    RESULTADO("WEB-INF/resultado/index.jsp");

		// Parte Dashboard (privada).
		
	    private final String url;

	    URL(final String url) {
	        this.url = url;
	    }

	    @Override
	    public String toString() {
	        return url;
	    }
	    
	}
	
}
