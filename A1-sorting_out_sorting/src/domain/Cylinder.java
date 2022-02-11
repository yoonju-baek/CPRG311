package domain;

/**
 * Represents a Cylinder shape.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 07 2022
 *
 */
public class Cylinder extends Shape {
	
	private double radius;

	/**
	 * Initializes a Cylinder object.
	 */
	public Cylinder() {
	}
	
	/**
	 * Initializes a Cylinder object.
	 * @param height the height
	 * @param radius the radius
	 */
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	/**
	 * Gets the radius
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Sets the radius
	 * @param radius the radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * Calculate volume of Cylinder
	 * @return volume of Cylinder
	 */
	@Override
	public double calcVolume() {
		return PI * Math.pow(getRadius(), 2) * getHeight();
	}

	/**
	 * Calculate base area of Cylinder
	 * @return base area of Cylinder
	 */
	@Override
	public double calcBaseArea() {
		return PI * Math.pow(getRadius(), 2);
	}

	public String toString() {
		return String.format("%-16s [Height=%10.3f, BaseArea=%15.3f, Volume=%20.3f]", "Cylinder", getHeight(), calcBaseArea(), calcVolume());
	}
}
