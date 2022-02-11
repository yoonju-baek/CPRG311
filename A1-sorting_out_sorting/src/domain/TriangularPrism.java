package domain;

/**
 * Represents a TriangularPrism shape.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 07 2022
 *
 */
public class TriangularPrism extends Prism {

	/**
	 * Initializes a TriangularPrism object.
	 */
	public TriangularPrism() {
	}
	
	/**
	 * Initializes a TriangularPrism object.
	 * @param height the height
	 * @param side the size
	 */
	public TriangularPrism(double height, double side) {
		super(height, side);
	}


	/**
	 * Calculate base area of TriangularPrism
	 * @return base area of TriangularPrism
	 */
	@Override
	public double calcBaseArea() {
		return (Math.pow(getSide(), 2) * Math.sqrt(3)) / 4;
	}

	public String toString() {
		return String.format("%-16s [Height=%10.3f, BaseArea=%15.3f, Volume=%20.3f]", "TriangularPrism", getHeight(), calcBaseArea(), calcVolume());
	}
}
