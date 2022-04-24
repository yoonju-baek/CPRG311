package problemdomain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a Location
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Apr 16 2022
 */
public class Location implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String fileName;
	private ArrayList<Integer> lineNumbers = new ArrayList<>();

	/**
	 * User defined constructor to initialize
	 * 
	 * @param fileName the path and filename of the text file
	 * @param lineNumber the line number which the word is found in that file
	 */
	public Location(String fileName, int lineNumber) {
		super();
		this.fileName = fileName;
		this.lineNumbers.add(lineNumber);
	}

	/**
	 * Gets the filename
	 * 
	 * @return the filename
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the filename
	 * 
	 * @param fileName the filename
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Gets the line number list
	 * 
	 * @return the list of the line number
	 */
	public ArrayList<Integer> getLineNumbers() {
		return lineNumbers;
	}

	/**
	 * Sets the line number in the list
	 * 
	 * @param lineNumbers the list of the line number
	 */
	public void setLineNumber(ArrayList<Integer> lineNumbers) {
		this.lineNumbers = lineNumbers;
	}
	
	/**
	 * Adds a new line number in the list
	 * 
	 * @param lineNumber the line number which the word is found
	 */
	public void addLineNumbers(int lineNumber) {
		this.lineNumbers.add(lineNumber);
	}
}
