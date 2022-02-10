package domain;

public class PentagonalPrism extends Prism {

	public PentagonalPrism() {
	}
	
	public PentagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return (5 * Math.pow(getSide(), 2) * Math.tan(54)) / 4;
	}

	public String toString() {
		return "PentagonalPrism [Height=" + getHeight()
							+ ", BaseArea="	+ String.format("%.3f", calcBaseArea()) 
							+ ", Volume=" + String.format("%.3f", calcVolume()) + "]";
	}
}
