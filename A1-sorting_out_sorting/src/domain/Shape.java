package domain;

public abstract class Shape implements Comparable<Shape>{
	final static double PI = 3.14;
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
	
	public abstract double calcVolume();
	public abstract double calcBaseArea();
	
	@Override
	public int compareTo(Shape that)
	{
		
		if( this.height > that.height ) {
			return 1;
		} else if( this.height < that.height ) {
			return -1;
		} else {
			return 0;
		}
	}

}
