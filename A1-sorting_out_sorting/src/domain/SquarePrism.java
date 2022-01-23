package domain;

public class SquarePrism extends Prism {

	public SquarePrism() {
	}
	
	public SquarePrism(double height, double side) {
		super(height, side);
	}


	@Override
	double calcBaseArea() {
		return Math.pow(getSide(), 2);
	}

}
