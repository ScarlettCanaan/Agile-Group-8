/**
 * 
 */
package agile8.test.system;
import agile8.system.*;

import junit.framework.TestCase;


import agile8.exceptions.NoSuchIDException;

/**
 * @author Canaan
 *
 */
public class GradeSystemTest extends TestCase {
	
	private GradeSystem _gradeSystem;

	/**
	 * Set up initial environment for test case.
	 * @throws java.lang.Exception
	 */

	public void setUp() throws Exception {
		super.setUp();
		_gradeSystem = new GradeSystem();
	}

	/**
	 * Reset environment for test case.
	 * @throws java.lang.Exception
	 */

	public void tearDown() throws Exception {
		super.setUp();
		_gradeSystem = null;
	}
	
	public void testShowGrade() {
		String actual = null;
		try {
			actual = _gradeSystem.showGrade("985002501");
		} catch (NoSuchIDException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String expected = "林佩穎 grades:\tlab1:\t\t93"
				+ "\r\n\t\tlab2:\t\t83"
				+ "\r\n\t\tlab3:\t\t94"
				+ "\r\n\t\tmid-term:\t91"
				+ "\r\n\t\ttotal grade:\t89";
		assertEquals("test ShowGrade should correct", expected, actual);
	}
	
	public void testShowGradeShouldFailed() {
		String id = "asdfwfewa";
		String message = "The input ID \"" + id + "\" does not exist!";
        try {
        	_gradeSystem.showGrade(id);
        }
		catch (NoSuchIDException e) {
			assertEquals("Test exception message should be equal", message, e.getMessage());
		}	
	}
	
	public void testShowRank() {
		String actual = null;
		try {
			actual = _gradeSystem.showGrade("985002501");
		} catch (NoSuchIDException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String expected = "林佩穎 ranking 29";
		assertEquals("test ShowGrade should correct", expected, actual);
	}
	
	public void testShowRankShouldFailed() {
		String id = "asdfwfewa";
		String message = "The input ID \"" + id + "\" does not exist!";
        try {
        	_gradeSystem.showGrade(id);
        }
		catch (NoSuchIDException e) {
			assertEquals("Test exception message should be equal", message, e.getMessage());
		}	
	}
	
}
