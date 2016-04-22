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
	}
	
	/**
	 * Starts the whole UI process.
	 */
	public void start() {
		while (!_exit) {
			try {
				if (login()) {
					eventLoop();
				}
			} catch (NoSuchIDException e) {
				System.out.println(e.getMessage());
			}
		}
		
		showFinishMessage();
	}
	
	/**
	 * Try to log the user in.
	 * @return Returns True if user logged in, returns
	 * False otherwise.
	 * @throws NoSuchIDException
	 */
	public boolean login() throws NoSuchIDException {
		promptID();
		String input = _reader.nextLine();
		
		if (!checkID(input)) {
			throw new NoSuchIDException("The input ID \"" + input + "\" does not exist!");
		}
		
		if (input.equals("Q")) {
			_exit = true;
			return false;
		}
		
		showWelcomeMessage(input);
		_userId = input;
		
		return true;
	}
	
	/**
	 * Starts the main event loop process.
	 */
	public void eventLoop() {
		while (!_exit) {			
			try {
				promptCommand();
			} catch (NoSuchCommandException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * Check if the given user id exists.
	 * @param id The user id to be checked
	 * @return Returns True if id is found, returns
	 * False otherwise.
	 */
	public boolean checkID(String id) {
		if (_gradeSystem.containsID(id)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Prompt all command options to user. Then reads user's
	 * input and execute corresponding operations.
	 * @return Returns the prompted command message.
	 * @throws NoSuchCommandException
	 */
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
	
	/**
	 * Prompts message to ask for user's ID. Also tell user
	 * can exit this grade system by entering 'Q'.
	 * @return Returns the prompted message.
	 */
	public String promptID() {
		String message = "Input ID or input Q to exit: ";
		System.out.println(message);
		return message;
	}
	
	/**
	 * Prompts finish message to user.
	 * @return Returns the prompted message.
	 */
	public String showFinishMessage() {
		String message = "Thanks for using :)";
		System.out.println(message);
		return message;
	}
	
	/**
	 * Prompts the welcome message to user.
	 * @return Returns the prompted message.
	 */
	public String showWelcomeMessage(String id) {
		String message = "Welcome " + id + "!";
		System.out.println(message);
		return message;
	}

}
