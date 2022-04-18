package exceptions;

/**
 * Represents Tree Exception.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Apr 09 2022
 */
public class TreeException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public TreeException() {
		super("[TreeException] The Tree is empty.");
	}

}
