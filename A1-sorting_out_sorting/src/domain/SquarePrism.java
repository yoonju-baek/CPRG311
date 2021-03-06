package domain;

/**
 * Represents a SquarePrism shape.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 07 2022
 *
 */
public class SquarePrism extends Prism {

	/**
	 * Initializes a SquarePrism object.
	 */
	public SquarePrism() {
	}
	
	/**
	 * Initializes a SquarePrism object.
	 * @param height the height
	 * @param side the side
	 */
	public SquarePrism(double height, double side) {
		super(height, side);
	}

	/**
	 * Calculate base area of SquarePrism
	 * @return base area of SquarePrism
	 */
	@Override
	public double calcBaseArea() {
		return Math.pow(getSide(), 2);
	}
	
	public String toString() {
		return String.format("%-16s [Height=%10.3f, Side=%10.3f, BaseArea=%15.3f, Volume=%20.3f]", "SquarePrism", getHeight(), getSide(), calcBaseArea(), calcVolume());
	}

}
