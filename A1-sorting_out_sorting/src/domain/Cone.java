package domain;

public class Cone extends Shape {

	private double radius;

	public Cone() {
	}
	
	public Cone(double height, double radius) {
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
		return PI * Math.pow(getRadius(), 2) * getHeight() / 3;
	}

	@Override
	public double calcBaseArea() {
		return PI * Math.pow(getRadius(), 2);
	}
	
	
}
