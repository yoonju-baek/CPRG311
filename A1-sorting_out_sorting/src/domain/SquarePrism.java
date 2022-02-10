package domain;

public class SquarePrism extends Prism {

	public SquarePrism() {
	}
	
	public SquarePrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return Math.pow(getSide(), 2);
	}
	
	public String toString() {
		return "SquarePrism [Height=" + getHeight()
						+ ", BaseArea="	+ String.format("%.3f", calcBaseArea()) 
						+ ", Volume=" + String.format("%.3f", calcVolume()) + "]";
	}

}
