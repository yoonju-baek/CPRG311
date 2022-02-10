package domain;

public class OctagonalPrism extends Prism {

	public OctagonalPrism() {
	}
	
	public OctagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * Math.pow(getSide(), 2);
	}

	public String toString() {
		return "OctagonalPrism [Height=" + getHeight()
							+ ", BaseArea="	+ String.format("%.3f", calcBaseArea()) 
							+ ", Volume=" + String.format("%.3f", calcVolume()) + "]";
	}
}
