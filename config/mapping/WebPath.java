package mapping;

public class WebPath {
	
	public enum URL {
		
		// Parte P�blica.
		
	    INDEX("index/index.jsp");

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
