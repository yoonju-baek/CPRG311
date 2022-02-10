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

	public String toString() {
		return "TriangularPrism [Height=" + getHeight()
							+ ", BaseArea="	+ String.format("%.3f", calcBaseArea()) 
							+ ", Volume=" + String.format("%.3f", calcVolume()) + "]";
	}
}
