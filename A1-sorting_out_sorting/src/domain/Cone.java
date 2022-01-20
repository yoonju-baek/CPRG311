package domain;

public class Cone extends Shape {

	private double radius;

	public Cone() {
	}
	
	public Cone(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	double calcVolume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double calcBaseArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
