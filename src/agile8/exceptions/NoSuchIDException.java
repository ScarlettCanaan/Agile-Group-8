package agile8.exceptions;

/**
 * NoSuchIDException is an Exception that will be
 * thrown when the ID is not found in the grade system. 
 * @author john29917958
 */
public class NoSuchIDException extends Exception {
	/**
	 * Constructor. Creates a NoSuchIDException instance.
	 */
	public NoSuchIDException() {
		super();
	}
	
	/**
	 * Constructor. Creates a NoSuchIDException instance
	 * with the given exception message.
	 * @param message The exception message.
	 */
	public NoSuchIDException(String message) {
		super(message);
	}
}
