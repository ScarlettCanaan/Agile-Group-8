/**
 * 
 */
package agile8.system;

/**
 * 
 * @author Canaan
 */
public class Grades {

	private String name;
	private String ID;
	private int lab1, lab2, lab3, midTerm, finalExam, totalGrade;
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name to set the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD to set the iD
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return lab1
	 */
	public int getLab1() {
		return lab1;
	}

	/**
	 * @param lab1 to set the lab1
	 */
	public void setLab1(int lab1) {
		this.lab1 = lab1;
	}

	/**
	 * @return lab2
	 */
	public int getLab2() {
		return lab2;
	}

	/**
	 * @param lab2 to set the lab2
	 */
	public void setLab2(int lab2) {
		this.lab2 = lab2;
	}

	/**
	 * @return lab3
	 */
	public int getLab3() {
		return lab3;
	}

	/**
	 * @param lab3 to set the lab3
	 */
	public void setLab3(int lab3) {
		this.lab3 = lab3;
	}

	/**
	 * @return midTerm
	 */
	public int getMidTerm() {
		return midTerm;
	}

	/**
	 * @param midTerm to set the midTerm
	 */
	public void setMidTerm(int midTerm) {
		this.midTerm = midTerm;
	}

	/**
	 * @return finalExam
	 */
	public int getFinalExam() {
		return finalExam;
	}

	/**
	 * @param finalExam to set the finalExam
	 */
	public void setFinalExam(int finalExam) {
		this.finalExam = finalExam;
	}

	/**
	 * @return totalGrade
	 */
	public int getTotalGrade() {
		return totalGrade;
	}

	/**
	 * Constructor. Creates a empty Grades instance.
	 */
	public Grades () {
		
	}
	
	/**
	 * Constructor. Creates a complete Grades instance.
	 * @param name
	 * @param iD
	 * @param lab1
	 * @param lab2
	 * @param lab3
	 * @param midTerm
	 * @param finalExam
	 */
	public Grades(String iD, String name, int lab1, int lab2, int lab3,
			int midTerm, int finalExam) {
		super();
		ID = iD;
		this.name = name;
		this.lab1 = lab1;
		this.lab2 = lab2;
		this.lab3 = lab3;
		this.midTerm = midTerm;
		this.finalExam = finalExam;
	}
	
	/**
	 * The method to calculate TotalGrade.
	 * @param weights 
	 * @return totalGrade
	 */
	public int calculateTotalGrade(float[] weights) {
		//if (weights[0] + weights[1] + weights[2] + weights[3] + weights[4] == 1.0)
		return this.totalGrade = (int)(lab1 * weights[0]
				+ lab2 * weights[1]
						+ lab3 * weights[2]
								+ midTerm* weights[3]
										+ finalExam * weights[4]);
	}
}
