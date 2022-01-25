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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcBaseArea() {
		// TODO Auto-generated method stub
		return 0;
	}

}
