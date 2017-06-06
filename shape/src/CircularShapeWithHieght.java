
public abstract class CircularShapeWithHieght extends CircularShape{
	
	double height;

	public CircularShapeWithHieght() {
		super();
		this.height = 0.0;
	}

	public CircularShapeWithHieght(double radius, double height) {
		super(radius);
		this.height = height;
		// TODO Auto-generated constructor stub
	}

	public double getHeight() {
		return height;
	}
		

}
