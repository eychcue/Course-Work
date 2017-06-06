
public abstract class PrismTriangleWithHeight extends PrismTriangle{
	
	
	double height;

	public PrismTriangleWithHeight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrismTriangleWithHeight(double altitude, double base, double side1, double side2, double side3, double height) {
		super(altitude, base, side1, side2, side3);
		this.height = height;
		// TODO Auto-generated constructor stub
	}

	public double getHeight() {
		return height;
	}	
	

}
