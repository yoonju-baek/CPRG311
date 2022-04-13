package exceptions;

public class TreeException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public TreeException() {
		super("[TreeException] The Tree is empty.");
	}

}
