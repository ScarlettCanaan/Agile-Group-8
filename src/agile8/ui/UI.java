package agile8.ui;

import java.util.Scanner;

import agile8.exceptions.NoSuchCommandException;
import agile8.exceptions.NoSuchIDException;
import agile8.system.GradeSystem;

/**
 * The user interface class which is response
 * of receiving user inputs and giving response
 * messages back to user.
 * @author john29917958
 */
public class UI {
	private GradeSystem _gradeSystem;
	private Scanner _reader;
	private boolean _exit;
	private String _userId;
	
	/**
	 * Constructor. Creates a UI instance.
	 */
	public UI() {
		_gradeSystem = new GradeSystem();
		_reader = new Scanner(System.in);
		_exit = false;
		_userId = "";
		
		while (!_exit) {
			try {
				start();
			} catch (NoSuchIDException e) {
				System.out.println(e.getMessage());
			}
		}
		
		showFinishMessage();
	}
	
	public void start() throws NoSuchIDException {
		promptID();
		String input = _reader.nextLine();
		
		if (!checkID(input)) {
			throw new NoSuchIDException("The input ID \"" + input + "\"does not exist!");
		}
		
		if (input.equals("Q")) {
			_exit = true;
			return;
		}
		
		showWelcomeMessage(input);
		_userId = input;
		
		while (!_exit) {			
			try {
				promptCommand();
			} catch (NoSuchCommandException e) {
				System.out.println(e.getMessage());
			}
		}
		
		_exit = true;
	}
	
	public boolean checkID(String id) {
		if (_gradeSystem.containsID(id)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String promptCommand() throws NoSuchCommandException {
		String message = "Input command:\n" +
				"1) G Show grades (Grade)\n" +
				"2) R Show rank (Rank)\n" +
				"3) W Update weights (Weight)\n" +
				"4) E Exit (Exit):";
		
		System.out.println(message);
		
		String input = _reader.nextLine();
		
		switch (input) {
			case "G":
				System.out.println(_gradeSystem.showGrade(_userId));
				break;
			case "R":
				System.out.println(_gradeSystem.showRank(_userId));
				break;
			case "W":
				_gradeSystem.updateWeights();
				break;
			case "E":
				_exit = true;
				break;
			default:
				throw new NoSuchCommandException("The command \"" + input + "\" is invalid.");
		}
		
		return message;
	}
	
	public String promptID() {
		String message = "Input ID or input Q to exit: ";
		System.out.println(message);
		return message;
	}
	
	public String showFinishMessage() {
		String message = "Thanks for using :)";
		System.out.println(message);
		return message;
	}
	
	public String showWelcomeMessage(String id) {
		String message = "Welcome " + id + "!";
		System.out.println(message);
		return message;
	}

}
