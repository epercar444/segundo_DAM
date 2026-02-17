package myapp.exceptions;

public class AutorNotFoundException extends RuntimeException{
	  /**
		 * 
		 */
		private static final long serialVersionUID = 5030665213865363481L;

	    public AutorNotFoundException() {
	        super();
	    }
	    public AutorNotFoundException(String message) {
	        super(message);
	    }
	    public AutorNotFoundException(long id) {
	        super("Autor not found: " + id);
	    }
}
