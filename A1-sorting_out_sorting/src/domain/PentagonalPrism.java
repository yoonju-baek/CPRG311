package domain;

public class PentagonalPrism extends Prism {

	public PentagonalPrism() {
	}
	
	public PentagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	double calcBaseArea() {
		return (5 * Math.pow(getSide(), 2) * Math.tan(54)) / 4;
	}

}
