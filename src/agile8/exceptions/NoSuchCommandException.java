package agile8.exceptions;

/**
 * NoSuchIDException is an Exception that will be
 * thrown when user inputs a non-exist command. 
 * @author john29917958
 */
public class NoSuchCommandException extends Exception {
	/**
	 * Constructor. Creates a NoSuchCommandException instance.
	 */
	public NoSuchCommandException() {
		super();
	}
	
	/**
	 * Constructor. Creates a NoSuchCommandException instance
	 * with the given exception message.
	 * @param message The exception message.
	 */
	public NoSuchCommandException(String message) {
		super(message);
	}
}
