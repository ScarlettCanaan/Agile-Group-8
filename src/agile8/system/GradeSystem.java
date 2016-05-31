package agile8.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import agile8.exceptions.NoSuchIDException;

public class GradeSystem {
	
	private float weights[]= { (float).1, (float).1, (float).1, (float).3, (float).4 };
	private LinkedList<Grades> _List;
	
	public GradeSystem() {
		_List = new LinkedList<Grades>();
		File file = new File("./gradeInput.txt");
		constructGrades(file);
	}
	
	public String showGrade(String id) throws NoSuchIDException {
		// TODO: Shows the grades of the user with given ID number.
		for(Grades grade: _List) {
			if (grade.getID().equals(id)) {
				String show = grade.getName() + " grades:\tlab1:\t\t" + grade.getLab1()
						+ "\r\n\t\tlab2:\t\t" + grade.getLab2()
						+ "\r\n\t\tlab3:\t\t" + grade.getLab3()
						+ "\r\n\t\tmid-term:\t" + grade.getMidTerm()
						+ "\r\n\t\tfinal exam:\t" + grade.getFinalExam()
						+ "\r\n\t\ttotal grade:\t" + grade.getTotalGrade();
				return show;
			}
		}
		throw new NoSuchIDException("The input ID \"" + id + "\" does not exist!");
	}
	
	public String showRank(String id) throws NoSuchIDException {
		// TODO: Shows the ranks of the user with given ID number.
		int rank = 1;
		int totalGrade;
		for(Grades gradefind : _List) {
			if (gradefind.getID().equals(id)) {
				totalGrade = gradefind.calculateTotalGrade(weights);
				for	(Grades gradeloop : _List) {
					if (gradeloop.calculateTotalGrade(weights) > totalGrade) {
						rank++;
					}
				}
				return gradefind.getName() + " ranking " + String.valueOf(rank);
			}
		}
		throw new NoSuchIDException("The input ID \"" + id + "\" does not exist!");
	}
	
	public void updateWeights() {
		// TODO: Calculate new weights.
		int temp[] = new int[5];
		int sum = 0;
		String nextByte = "N";
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Old weight:\r\n\tlab1\t\t" + (int)(weights[0] * 100)
					+ "%\r\n\tlab2\t\t" + (int)(weights[1] * 100)
					+ "%\r\n\tlab3\t\t" + (int)(weights[2] * 100)
					+ "%\r\n\tmid-term\t" + (int)(weights[3] * 100)
					+ "%\r\n\tfinal exam\t" + (int)(weights[4] * 100) + "%");
			System.out.print("Press new weight:\r\n\tlab1\t\t");
			temp[0] = scanner.nextInt();
			System.out.print("\tlab2\t\t");
			temp[1] = scanner.nextInt();
			System.out.print("\tlab3\t\t");
			temp[2] = scanner.nextInt();
			System.out.print("\tmid-term\t");
			temp[3] = scanner.nextInt();
			System.out.print("\tfinal exam\t");
			temp[4] = scanner.nextInt();
			for (int i : temp) {
				sum += i;
			}
			if (sum == 100) {
				System.out.println("Please confirm new weight:\r\n\tlab1\t\t" + temp[0]
						+ "%\r\n\tlab2\t\t" + temp[1]
						+ "%\r\n\tlab3\t\t" + temp[2]
						+ "%\r\n\tmid-term\t" + temp[3]
						+ "%\r\n\tfinal exam\t" + temp[4]
						+ "%\nConfirm that the correct or not?Y(Yes) or N(No)");
				sum = 0;
				nextByte = scanner.next();
			} else {
				System.out.println("New weight invaild,sum of weight must equals 100!");
				sum = 0;
			}
		} while (!nextByte.equals("Y"));
		for (int i = 0; i < 5; ++i) {
			weights[i] = temp[i] / 100;
		}
		for (Grades g : _List) {
			g.calculateTotalGrade(weights);
		}
		System.out.println("Weights updated!");
	}
	
	public boolean containsID(String id) {
		// TODO: Check if input id is contained in the
		// user list.
		for(Grades grade: _List) {
			if (grade.getID().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	private void constructGrades(File file) {
		String tempStr;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			while ((tempStr = reader.readLine()) != null) {
				addGrade(tempStr);
			}
		}catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
	}
	
	private void addGrade(String str) {
		String[] element = str.split(" ");
		Grades grades = new Grades(element[0], element[1], 
				Integer.parseInt(element[2]), Integer.parseInt(element[3]), Integer.parseInt(element[4]),
				Integer.parseInt(element[5]), Integer.parseInt(element[6])
				);
		grades.calculateTotalGrade(weights);
		_List.add(grades);
	}
}
