package agile8.tests.exceptions;

import agile8.exceptions.NoSuchIDException;
import junit.framework.TestCase;

public class NoSuchIDExceptionTest extends TestCase {
	/**
	 * Set up initial environment for test case.
	 * @throws Exception
	 */
	protected void setUp() throws Exception {
		super.setUp();
    }

	/**
	 * Reset environment for test case.
	 * @throws Exception 
	 */
    protected void tearDown() throws Exception {
    	super.setUp();
    }
    
    /**
     * Test create a default exception.
     */
    public void testCreateException() {
    	NoSuchIDException exception = new NoSuchIDException();
 
    	assertNotNull("Test exception should be created", exception);
        assertEquals("Test exception message should be empty", null, exception.getMessage());
    }
    
    /**
     * Test create an exception with given message.
     */
    public void testCreateExceptionWithMessage() {
    	String message = "What a wonderful day";
    	NoSuchIDException exception = new NoSuchIDException(message);
    	 
    	assertNotNull("Test exception should be created", exception);
        assertEquals("Test exception message should be empty", message, exception.getMessage());
    }
}
