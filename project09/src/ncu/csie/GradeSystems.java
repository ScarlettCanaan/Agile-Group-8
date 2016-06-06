package ncu.csie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import ncu.csie.modle.Grades;

/**
 * *************************************************************************
 * class GradeSystems纗 a list of student grades.
 * 
 * containsID(ID) //aGradeSystemΤID GradeSystems () //篶 showGrade(ID)
 * //陪ボID厩ネΘ罿 showRank(ID) //陪ボID厩ネ逼 updateWeights () //эだ计璸衡舦
 *************************************************************************** */

public class GradeSystems {
	public float[] weights = { 0.1f, 0.1f, 0.1f, 0.3f, 0.4f };
	public LinkedList<Grades> aList = new LinkedList<Grades>();
	Grades temp;
	Grades currentUser;
	Scanner scanner;

	GradeSystems(Scanner scanner) {
		this.scanner = scanner;
		BufferedReader in;
		String text;
		String gInformation[];

		try {
			in = new BufferedReader(new FileReader("input.txt"));
			do {
				text = in.readLine();
				if (text != null) {
					temp = new Grades();
					gInformation = text.split(" ");
					//System.out.printf(gInformation[1]);	
					temp.setID(gInformation[0]);
					temp.setName(gInformation[1]);
					temp.setlab1(Integer.valueOf(gInformation[2]));
					temp.setlab2(Integer.valueOf(gInformation[3]));
					temp.setlab3(Integer.valueOf(gInformation[4]));
					temp.setmidTerm(Integer.valueOf(gInformation[5]));
					temp.setfinalExam(Integer.valueOf(gInformation[6]));
					temp.calculateTotalGrade(weights);
					aList.add(temp);
				}

			} while (text != null);
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ------------------------------------------------------------------------
	 * containsID (ID) return int parameter(index of data): ID a user ID ex:
	 * 123456789 time: O(n) n is aGradeSystem ず痁计
	 * 
	 * -------------------------------------------------------------------------
	 */
	public int containsID(String Id) {
		for (int nOfId = 0; nOfId < aList.size(); nOfId++) {
			if (aList.get(nOfId).getID().equals(Id)) {
				currentUser = aList.get(nOfId);
				return nOfId;
			}
		}
		return -1;
	}

	/**
	 * ------------------------------------------------------------------------
	 * showGrade (ID) return String parameter: ID a user ID ex: 123456789 time:
	 * O(n) n is aGradeSystem ず痁计
	 * 
	 * -------------------------------------------------------------------------
	 */
	public String showGrade(String Id) {
		for (int nOfId = 0; nOfId < aList.size(); nOfId++) {
			if (aList.get(nOfId).getID().equals(Id)) {
				temp = aList.get(nOfId);
				String grade = String
						.format("%sΘ罿 lab1     %s\n\tlab2     %s\n\tlab3     %s\n\tmid-term :  %s\n\tfinal exam%s\n\ttotal grade : %s\n",
								temp.getName(), temp.getlab1(), temp.getlab2(),
								temp.getlab3(), temp.getmidTerm(),
								temp.getfinalExam(), temp.getTotalGrade());
				System.out.print(grade);
				return grade;
			}
		}
		return null;
	}

	/**
	 * ------------------------------------------------------------------------
	 * showRank (ID) return int parameter(rank): ID a user ID ex: 123456789
	 * time: O(n) n is aGradeSystem ず痁计
	 * 
	 * -------------------------------------------------------------------------
	 */
	public int showRank(String Id) {
		int rank = 1;
		int theTotalGrade = 0;
		int indexOfId = 0;
		for (int nOfId = 0; nOfId < aList.size(); nOfId++) {
			if (aList.get(nOfId).getID().equals(Id)) {
				theTotalGrade = aList.get(nOfId).getTotalGrade();
				indexOfId = nOfId;
				break;
			}
		}
		for (Grades temp : aList) {
			if (!temp.getID().equals(Id)) {
				if (temp.getTotalGrade() >= theTotalGrade)
					rank++;
			}
		}
		System.out.printf("%s逼材%d\r\n", aList.get(indexOfId).getName(), rank);

		return rank;
	}

	public String getStudentName(int nOfId) {

		return aList.get(nOfId).getName();
	}

	public void updateWeights() {

		float[] newWeight = new float[5];
		showOldWeights();
		getNewWeights(newWeight);
		setWeights(newWeight);
		for (Grades temp : aList) {
			temp.calculateTotalGrade(weights);
		}
	}

	private void setWeights(float[] newWeight) {
		System.out
				.printf("叫絋粄穝皌だ\n\tlab1 %.0f%%\n\tlab2 %.0f%%\n\tlab3 %.0f%%\n\tmid-term %.0f%%\n\tfinal exam %.0f%%\n  タ絋盾? Y (Yes) ┪ N (No)",
						newWeight[0], newWeight[1], newWeight[2], newWeight[3],
						newWeight[4]);

		if (scanner.next().charAt(0) == 'Y') {
			weights = newWeight;
		}
	}

	private void getNewWeights(float[] newWeight) {
		System.out.println("块穝皌だ");
		System.out.printf("\tlab1 ");
		newWeight[0] = Float.valueOf(scanner.next());
		System.out.printf("\tlab2 ");
		newWeight[1] = Float.valueOf(scanner.next());
		System.out.printf("\tlab3 ");
		newWeight[2] = Float.valueOf(scanner.next());
		System.out.printf("\tmid-term ");
		newWeight[3] = Float.valueOf(scanner.next());
		System.out.printf("\tfinalExam ");
		newWeight[4] = Float.valueOf(scanner.next());
	}

	private void showOldWeights() {
		System.out
				.printf("侣皌だ\n\tlab1 %.0f%%\n\tlab2 %.0f%%\n\tlab3 %.0f%%\n\tmid-term %.0f%%\n\tfinal exam %.0f%%\n",
						weights[0] * 100, weights[1] * 100, weights[2] * 100,
						weights[3] * 100, weights[4] * 100);
	}
	
	public void modifyGrades() {
		String[] gradeName = {"Lab1", "Lab2" , "Lab3", "Mid-term", "Final exam"};
		System.out.println("輸入更改分數學生的ID");
		String inputID = scanner.next();
		int studIDIndex;
		if	((studIDIndex = containsID(inputID)) >= 0) {
			String studName = getStudentName(studIDIndex);
			System.out.println(studIDIndex);
			showGrade(inputID);
			String inputCommand;
			for	(int i = 0; i < gradeName.length; ++i) {
				System.out.print("更改" + studName + gradeName[i] + "分數? (yes/no) ");
				inputCommand = scanner.next();
				if (inputCommand.equals("yes")) {
					System.out.print("输入" +  studName + gradeName[i] + "新分數  ");
					String inputGrade = scanner.next();
					setGrade(studIDIndex, i, Integer.parseInt(inputGrade));
					System.out.println(studName + "新分數" + gradeName[i] + inputGrade + " 改好了");
				}
			}
			System.out.println("更改分數" + inputID + studName + " 完成了");
		}
	}
	
	private void setGrade(int studID, int i, int grade) {
		switch (i) {
		case 0:
			aList.get(studID).setlab1(grade);
			break;
		case 1:
			aList.get(studID).setlab2(grade);
			break;
		case 2:
			aList.get(studID).setlab3(grade);
			break;
		case 3:
			aList.get(studID).setmidTerm(grade);
			break;
		case 4:
			aList.get(studID).setfinalExam(grade);
			break;
		}
	}

}
