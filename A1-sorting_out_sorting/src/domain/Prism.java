package domain;

public abstract class Prism extends Shape {
	
	private double side;
	
	public Prism(double side) {
		super();
		this.side = side;
	}
	
	public double calcVolume() {
		return 0;
	}
	
	abstract double calcBaseArea();

}
