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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcBaseArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
