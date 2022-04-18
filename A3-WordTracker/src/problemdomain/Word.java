package problemdomain;

import java.util.ArrayList;

/**
 * Represents a word
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Apr 16 2022
 */
public class Word implements Comparable<Word> {
	private String word;
	private int occurrence;
	
	//The line numbers should be stored with the file names, 
	//which in turn are associated with the nodes of the tree.
	private String filename;
	private ArrayList<Integer> lineNumList;
	
		
	/**
	 * User defined constructor to initialize
	 * @param word
	 */
	public Word(String word, String filename) {
		this.word = word;
		this.occurrence = 1;
		this.filename = filename;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getOccurrence() {
		return occurrence;
	}

	public void increaseOccurrence() {
		occurrence++;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public ArrayList<Integer> getLineNumList() {
		return lineNumList;
	}

	public void addLineNumbers(int lineNumbers) {
		lineNumList.add(lineNumbers);
	}

	@Override
	public int compareTo(Word that) {
		return (this.word.compareTo(that.word));
	}
	
}
