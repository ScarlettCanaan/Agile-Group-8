package agile8.tests.exceptions;

import agile8.exceptions.NoSuchCommandException;
import junit.framework.TestCase;

public class NoSuchCommandExceptionTest extends TestCase {

	/**
	 * Set up initial environment for test case.
	 */
	protected void setUp() {
		// 
    }

	/**
	 * Reset environment for test case.
	 */
    protected void tearDown() {
        //
    }

    /**
     * Test create a default exception.
     */
    public void testCreateException() {
    	NoSuchCommandException exception = new NoSuchCommandException();
 
    	assertNotNull("Test exception should be created", exception);
        assertEquals("Test exception message should be empty", null, exception.getMessage());
    }
    
    /**
     * Test create an exception with given message.
     */
    public void testCreateExceptionWithMessage() {
    	String message = "What a wonderful day";
    	NoSuchCommandException exception = new NoSuchCommandException(message);
    	 
    	assertNotNull("Test exception should be created", exception);
        assertEquals("Test exception message should be empty", message, exception.getMessage());
    }
}
