package ncu.csie;

import java.util.Scanner;

import ncu.csie.exceptions.NoSuchCommandExceptions;
import ncu.csie.exceptions.NoSuchIDExceptions;

/**
 * *********************************************************************** class
 * UI (user interface)
 * 
 * checkID(ID) //ÀË¬dID¬O§_¦s¦b promptCommand() //­n¨D¿é¤J«ü¥O promptID() //­n¨D¿é¤JID
 * showFinishMsg() //Åã¥Üµ²§ô°T®§ showWelcomeMsg() //Åã¥ÜÅwªï°T®§ UI() «Øºc¤l «Øºc aGradeSystem
 ************************************************************************ */

public class UI {
	public GradeSystems aGradeSystem;
	Scanner scanner = new Scanner(System.in);
	String loginStuId;
	int loginStuIndex;

	/**
	 * ------------------------------------------------------------------------
	 * UI() «Øºc¤l throws NoSuchIDExceptions, NoSuchCommandExceptions
	 * ------------------------------------------------------------
	 */

	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		try {
			aGradeSystem = new GradeSystems(scanner);
			while (true) {
				String inputId = promptID();
				if (inputId.equals("Q"))
					break;
				else if ((loginStuIndex = checkID(inputId)) >= 0) {
					loginStuId = inputId;
					showWelcomeMsg(loginStuIndex);
					promptCommand();
				} else
					throw new NoSuchIDExceptions();
			}
			showFinishMsg();
		} finally {

		}

	}

	/**
	 * ------------------------------------------------------------------------
	 * checkID (ID) throws NoSuchIDExceptions return Boolean parameter: ID a
	 * user ID ex: 123456789 time: O(n) n is aGradeSystem ¤º¥þ¯Z¤H¼Æ
	 * 
	 * -------------------------------------------------------------------------
	 */

	public int checkID(String id) throws NoSuchIDExceptions {
		return aGradeSystem.containsID(id);
	}

	/**
	 * ------------------------------------------------------------------------
	 * promptCommand () throws NoSuchCommandExceptions
	 * ---------------------------------------------------------------
	 */

	public void promptCommand() throws NoSuchCommandExceptions {
		while (true) {
			System.out
					.println("¿é¤J«ü¥O\n\t1) G Åã¥Ü¦¨ÁZ (Grade)\n\t2) R Åã¥Ü±Æ¦W (Rank)\n\t3) W§ó·s°t¤À (Weight)\n\t4) M§ó¸ü¸Ä·Ö”µ (Modify)\n\t5)Q ëxé_ (Quit)\t¨Ï¥ÎªÌ¿é¤J¡G");
			String intputCommand = scanner.next();
			switch (intputCommand.charAt(0)) {
			case 'G':
				aGradeSystem.showGrade(loginStuId);
				break;
			case 'R':
				aGradeSystem.showRank(loginStuId);
				break;
			case 'W':
				aGradeSystem.updateWeights();
				break;
			case 'M':
				aGradeSystem.modifyGrades();
				break;
			case 'E':
				return;
			default:
				throw new NoSuchCommandExceptions();
			}
		}

	}

	private String promptID() {
		System.out.println("¿é¤JID©Î Q (µ²§ô¨Ï¥Î)");
		return scanner.next();
	}

	private void showFinishMsg() {
		System.out.println("µ²§ô¤F");
	}

	private void showWelcomeMsg(int loginStuIndex) {
		System.out.println("Welcome "
				+ aGradeSystem.getStudentName(loginStuIndex));

	}

}
