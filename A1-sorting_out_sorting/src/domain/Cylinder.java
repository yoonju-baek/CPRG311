package domain;

public class Cylinder extends Shape {
	
	private double radius;

	public Cylinder() {
	}
	
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calcVolume() {
		return PI * Math.pow(getRadius(), 2) * getHeight();
	}

	@Override
	public double calcBaseArea() {
		return PI * Math.pow(getRadius(), 2);
	}

}
