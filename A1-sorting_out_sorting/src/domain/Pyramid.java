package domain;

public class Pyramid extends Shape {
	
	private double side;
	

	public Pyramid(double side) {
		super();
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
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
