package domain;

/**
 * Represents a Prism shape.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 07 2022
 *
 */
public abstract class Prism extends Shape {
	
	private double side;
	
	/**
	 * Initializes a Prism object.
	 */
	public Prism() {
	}
	
	/**
	 * Initializes a Prism object.
	 * @param height the height
	 * @param side the side
	 */
	public Prism(double height, double side) {
		super(height);
		this.side = side;
	}

	/**
	 * Gets the side
	 * @return the side
	 */
	public double getSide() {
		return side;
	}

	/**
	 * Sets the side
	 * @param side the side
	 */
	public void setSide(double side) {
		this.side = side;
	}
	
	/**
	 * Calculate volume of Prism
	 * @return volume of Prism
	 */
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}
	
	/**
	 * Abstract method that calculate base area of Prism
	 */
	public abstract double calcBaseArea();

}
