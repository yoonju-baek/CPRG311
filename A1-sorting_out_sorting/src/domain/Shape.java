package domain;

public abstract class Shape {
	private double height;
	
	public Shape() {
	}
	
	public Shape(double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	abstract double calcVolume();
	abstract double calcBaseArea();
}
