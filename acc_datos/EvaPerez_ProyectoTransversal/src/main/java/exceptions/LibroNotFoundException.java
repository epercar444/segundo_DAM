package exceptions;

public class LibroNotFoundException extends RuntimeException{
	  /**
		 * 
		 */
		private static final long serialVersionUID = 5030665213865363481L;

	    public LibroNotFoundException() {
	        super();
	    }
	    public LibroNotFoundException(String message) {
	        super(message);
	    }
	    public LibroNotFoundException(long id) {
	        super("Libro not found: " + id);
	    }
}
