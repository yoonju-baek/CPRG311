package domain;

/**
 * Represents a Cone shape.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 07 2022
 *
 */
public class Cone extends Shape {

	private double radius;

	/**
	 * Initializes a Cone object.
	 */
	public Cone() {
	}
	
	/**
	 * Initializes a Cone object.
	 * @param height the height
	 * @param radius the radius
	 */
	public Cone(double height, double radius) {
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
	 * Calculate volume of Cone
	 * @return volume of Cone
	 */
	@Override
	public double calcVolume() {
		return PI * Math.pow(getRadius(), 2) * getHeight() / 3;
	}

	/**
	 * Calculate base area of Cone
	 * @return base area of Cone
	 */
	@Override
	public double calcBaseArea() {
		return PI * Math.pow(getRadius(), 2);
	}
	
	public String toString() {
		return String.format("%-16s [Height=%10.3f, Raid=%10.3f, BaseArea=%15.3f, Volume=%20.3f]", "Cone", getHeight(), getRadius(), calcBaseArea(), calcVolume());
	}
}
