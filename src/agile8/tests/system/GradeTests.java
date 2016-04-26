/**
 * 
 */
package agile8.test.system;
import agile8.system.*;

import junit.framework.TestCase;

/**
 * @author Canaan
 *
 */
public class GradeTests extends TestCase {
	
	private Grades _grades;

	/**
	 * Set up initial environment for test case.
	 * @throws java.lang.Exception
	 */

	public void setUp() throws Exception {
		super.setUp();
		_grades = new Grades();
	}

	/**
	 * Reset environment for test case.
	 * @throws java.lang.Exception
	 */

	public void tearDown() throws Exception {
		super.setUp();
		_grades = null;
	}


	public void testCalculateTotalGrade1() {
		float weightCase[] = { (float)0.1, (float)0.1, (float)0.1, (float)0.3, (float)0.4 };
		int expected = (int) (81*0.1+98*0.1+84*0.1+90*0.3+93*0.4);
		int actual = _grades.calculateTotalGrade(weightCase);
		assertEquals("test CalcutateTotalGrade1 should correct", expected, actual);
	}
	
	public void testCalculateTotalGrade2() {
		float weightCase[] = { (float)0.2, (float)0.2, (float)0.2, (float)0.2, (float)0.2 };
		int expected = (int) (81*0.2+98*0.2+84*0.2+90*0.2+93*0.2);
		int actual = _grades.calculateTotalGrade(weightCase);
		assertEquals("test CalcutateTotalGrade2 should correct", expected, actual);
	}
	
	public void testCalculateTotalGrade3() {
		float weightCase[] = { (float)0.1, (float)0.1, (float)0.0, (float)0.4, (float)0.4 };
		int expected = (int) (81*0.1+98*0.1+84*0.0+90*0.4+93*0.4);
		int actual = _grades.calculateTotalGrade(weightCase);
		assertEquals("test CalcutateTotalGrade3 should correct", expected, actual);
	}
	
}
