package myapp.exceptions;

public class LectorNotFoundException extends RuntimeException{
	  /**
		 * 
		 */
		private static final long serialVersionUID = 5030665213865363481L;

	    public LectorNotFoundException() {
	        super();
	    }
	    public LectorNotFoundException(String message) {
	        super(message);
	    }
	    public LectorNotFoundException(long id) {
	        super("Lector not found: " + id);
	    }
}
