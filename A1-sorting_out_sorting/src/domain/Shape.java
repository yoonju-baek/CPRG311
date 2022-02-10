package domain;

/**
 * Represents a Shape.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 07 2022
 *
 */
public abstract class Shape implements Comparable<Shape>{
	final static double PI = 3.14;
	private double height;
	
	/**
	 * Initializes a Shape object.
	 */
	public Shape() {
	}
	
	/**
	 * Initializes a Shape object.
	 * @param height the height
	 */
	public Shape(double height) {
		this.height = height;
	}

	/**
	 * Gets the height
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Sets the height
	 * @param height the height
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * Abstract method that calculate volume
	 */
	public abstract double calcVolume();
	
	/**
	 * Abstract method that calculate base area
	 */
	public abstract double calcBaseArea();
	
	/**
	 * Compare the height of Shape
	 * @return -1 if this object is less that, 0 if this object is equal to that , 1 this object is greater than that.
	 */
	@Override
	public int compareTo(Shape that)
	{
		
		if( this.height > that.height ) {
			return 1;
		} else if( this.height < that.height ) {
			return -1;
		} else {
			return 0;
		}
	}

}
