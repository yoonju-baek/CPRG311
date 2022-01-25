package domain;

public class TriangularPrism extends Prism {

	public TriangularPrism() {
	}
	
	public TriangularPrism(double height, double side) {
		super(height, side);
	}


	@Override
	public double calcBaseArea() {
		return (Math.pow(getSide(), 2) * Math.sqrt(3)) / 4;
	}

}
