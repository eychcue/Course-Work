
public class TrianglePrism extends PrismTriangle implements Shape{

	double altitude;
	double base;
	double side1;
	double side2;
	double side3;
	double height;
	
	public TrianglePrism(double altitude, double base, double side1, double side2, double side3, double height) {
		super(altitude, base, side1, side2, side3, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getSurfaceArea() {
		// TODO Auto-generated method stub
		return (getBaseArea()/2.0)*(getPerimeter()*getHeight());
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return getBaseArea()*getHeight();
	}

	@Override
	public String toString() {
		return "Shape: Triangle Prism \n Surface Area "+getSurfaceArea() +" \nVolume "+getVolume();
	}
}
