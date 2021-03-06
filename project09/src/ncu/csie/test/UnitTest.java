package ncu.csie.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ncu.csie.UI;
import ncu.csie.exceptions.NoSuchCommandExceptions;
import ncu.csie.exceptions.NoSuchIDExceptions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {
	UI myUI = null;
	ByteArrayOutputStream outContent = null;
	ByteArrayInputStream inContent = null;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		myUI = null;
	}

	@Test
	public void testFinishMsg() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals("輸入ID或 Q (結束使用)\r\n結束了\r\n", outContent.toString());

	}

	@Test
	public void testShowGrade1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("985002010\nG\nE\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals(
				"楊君山成績： lab1：     96　\n\tlab2：     95　\n\tlab3：     91　\n\tmid-term :  86　\n\tfinal exam：96　\n\ttotal grade : 92\n",
				myUI.aGradeSystem.showGrade("985002010"));

	}

	@Test
	public void testShowGrade2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("985002201\nG\nE\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals(
				"蘇亮成績： lab1：     81　\n\tlab2：     91　\n\tlab3：     85　\n\tmid-term :  84　\n\tfinal exam：90　\n\ttotal grade : 87\n",
				myUI.aGradeSystem.showGrade("985002201"));

	}

	@Test
	public void testShowRank1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("985002201\nR\nE\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals(53, myUI.aGradeSystem.showRank("985002201"));

	}

	@Test
	public void testShowRank2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("985002009\nR\nE\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();

		assertEquals(15, myUI.aGradeSystem.showRank("985002009"));

	}

	@Test
	public void testUpdateWeights1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream(
				"985002009\nW\n20\n20\n20\n20\n20\nY\nE\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(true, myUI.aGradeSystem.weights[0] == 20
				&& myUI.aGradeSystem.weights[1] == 20
				&& myUI.aGradeSystem.weights[2] == 20
				&& myUI.aGradeSystem.weights[3] == 20
				&& myUI.aGradeSystem.weights[4] == 20);
	}

	@Test
	public void testUpdateWeights2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream(
				"985002009\nW\n30\n20\n0\n15\n35\nY\nE\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(true, myUI.aGradeSystem.weights[0] == 30
				&& myUI.aGradeSystem.weights[1] == 20
				&& myUI.aGradeSystem.weights[2] == 0
				&& myUI.aGradeSystem.weights[3] == 15
				&& myUI.aGradeSystem.weights[4] == 35);
	}

	@Test
	public void testContainsID1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(true, myUI.aGradeSystem.containsID("985002009") >= 0);
	}

	@Test
	public void testContainsID2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(false, myUI.aGradeSystem.containsID("123456") >= 0);
	}
	
	@Test
	public void testModityGrade() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("962001044\nM\n962001044\nno\nyes\n90\nno\nno\nno\nQ".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
		assertEquals(false, myUI.aGradeSystem.aList.get(1).getlab2() == 90);
}	

	@Test(expected = NoSuchCommandExceptions.class)
	public void testException1() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("985002009\nX\n".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
	}

	@Test(expected = NoSuchIDExceptions.class)
	public void testException2() throws NoSuchIDExceptions,
			NoSuchCommandExceptions {

		inContent = new ByteArrayInputStream("123456\n".getBytes());
		System.setIn(inContent);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		myUI = new UI();
	}

}
