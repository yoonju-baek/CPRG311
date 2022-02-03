package domain;

public class Pyramid extends Shape {
	
	private double side;
	
	public Pyramid() {
	}
	
	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double calcVolume() {
		return Math.pow(getSide(), 2) * getHeight() / 3;
	}

	@Override
	public double calcBaseArea() {
		return Math.pow(getSide(), 2);
	}
	
}
