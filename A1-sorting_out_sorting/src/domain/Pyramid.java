package domain;

/**
 * Represents a Pyramid shape.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 07 2022
 *
 */
public class Pyramid extends Shape {
	
	private double side;
	
	/**
	 * Initializes a Pyramid object.
	 */
	public Pyramid() {
	}
	
	/**
	 * Initializes a Pyramid object.
	 * @param height the height
	 * @param side the side
	 */
	public Pyramid(double height, double side) {
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
	 * Calculate volume of Pyramid
	 * @return volume of Pyramid
	 */
	@Override
	public double calcVolume() {
		return Math.pow(getSide(), 2) * getHeight() / 3;
	}

	/**
	 * Calculate base area of Pyramid
	 * @return base area of Pyramid
	 */
	@Override
	public double calcBaseArea() {
		return Math.pow(getSide(), 2);
	}
	
	public String toString() {
		return String.format("%-16s [Height=%10.3f, BaseArea=%15.3f, Volume=%20.3f]", "Pyramid", getHeight(), calcBaseArea(), calcVolume());
	}
}
