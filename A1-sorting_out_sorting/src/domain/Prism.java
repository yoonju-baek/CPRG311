package domain;

public class Prism extends Shape {
	
	private double side;

	
	public Prism(double side) {
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
