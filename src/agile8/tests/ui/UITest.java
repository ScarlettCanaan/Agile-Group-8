package agile8.tests.ui;

import agile8.ui.UI;
import junit.framework.TestCase;

public class UITest extends TestCase {
	private UI _ui;

	/**
	 * Set up initial environment for test case.
	 * @throws Exception
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		_ui = new UI();
	}

	/**
	 * Reset environment for test case.
	 * @throws Exception 
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		
		_ui = null;
	}
	
	public void testCheckId() {
		boolean actual = _ui.checkID("955002056");
		assertTrue("test ID should be found", actual);
	}
	
	public void testCheckIdShouldFail() {
		boolean actual = _ui.checkID("sdflkjjdf32");
		assertFalse("test non-exist ID should be checked", actual);
	}

	public void testPromptID() {
		String expect = "Input ID or input Q to exit: ";
		assertEquals("test prompt ID message should correct", expect, _ui.promptID());
	}
	
	public void testShowFinishMessage() {
		String expect = "Thanks for using :)";
		assertEquals("test finish message should correct", expect, _ui.showFinishMessage());
	}
	
	public void testShowWelcomeMessage() {
		String id = "955002056";
		String expect = "Welcome " + id + "!";
		assertEquals("test welcome message should correct", expect, _ui.showWelcomeMessage(id));
	}
	
}
