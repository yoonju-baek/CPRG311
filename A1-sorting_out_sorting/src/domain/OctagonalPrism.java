package domain;

/**
 * Represents a OctagonalPrism shape.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 07 2022
 *
 */
public class OctagonalPrism extends Prism {
	/**
	 * Initializes a OctagonalPrism object.
	 */
	public OctagonalPrism() {
	}
	
	/**
	 * Initializes a OctagonalPrism object.
	 * @param height the height
	 * @param side the side
	 */
	public OctagonalPrism(double height, double side) {
		super(height, side);
	}

	/**
	 * Calculate base area of OctagonalPrism
	 * @return base area of OctagonalPrism
	 */
	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * Math.pow(getSide(), 2);
	}

	public String toString() {
		return "OctagonalPrism [Height=" + getHeight()
							+ ", BaseArea="	+ String.format("%.3f", calcBaseArea()) 
							+ ", Volume=" + String.format("%.3f", calcVolume()) + "]";
	}
}
