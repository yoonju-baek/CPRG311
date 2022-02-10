package domain;

/**
 * Represents a PentagonalPrism shape.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 07 2022
 *
 */
public class PentagonalPrism extends Prism {

	/**
	 * Initializes a PentagonalPrism object.
	 */
	public PentagonalPrism() {
	}
	
	/**
	 * Initializes a PentagonalPrism object.
	 * @param height the height
	 * @param side the side
	 */
	public PentagonalPrism(double height, double side) {
		super(height, side);
	}

	/**
	 * Calculate base area of PentagonalPrism
	 * @return base area of PentagonalPrism
	 */
	@Override
	public double calcBaseArea() {
		return (5 * Math.pow(getSide(), 2) * Math.tan(54)) / 4;
	}

}
