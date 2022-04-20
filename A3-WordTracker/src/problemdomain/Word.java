package problemdomain;

import java.util.ArrayList;

/**
 * Represents a Word
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Apr 16 2022
 */
public class Word implements Comparable<Word>{
	private String word;
	private int occurrence;
	private ArrayList<Location> locations = new ArrayList<>();
	
	/**
	 * User defined constructor to initialize
	 * 
	 * @param word the word
	 * @param locations location that the word occurred
	 */
	public Word(String word, Location locations) {
		super();
		this.word = word;
		this.occurrence =  1;
		this.locations.add(locations);
	}

	/**
	 * User defined constructor to initialize
	 * 
	 * @param word the word
	 */
	public Word(String word) {
		this.word = word;
		this.occurrence = 1;
	}

	/**
	 * Gets the word
	 * 
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Sets the word
	 * 
	 * @param word the word
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * Gets the occurrence
	 * 
	 * @return the occurrence
	 */
	public int getOccurrence() {
		return occurrence;
	}

	/**
	 * Increase the occurrence
	 */
	public void increaseOccurrence() {
		occurrence++;
	}

	/**
	 * Gets the locations
	 * 
	 * @return the locations
	 */
	public ArrayList<Location> getLocations() {
		return locations;
	}

	/**
	 * Sets the locations
	 * 
	 * @param locations the locations
	 */
	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}
	
	/**
	 * Adds the extra location in the locations list
	 * 
	 * @param locations the extra location
	 */
	public void addLocation(Location locations) {
		this.locations.add(locations);
	}
	

	/**
	 * Compare the word
	 * 
	 * @param that the Word object to be compared
	 * @return -1 if this object is less that, 0 if this object is equal to that , 1 this object is greater than that.
	 */
	@Override
	public int compareTo(Word that) {
		return (this.word.compareTo(that.getWord()));
	}
	
}