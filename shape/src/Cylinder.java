
public class Cylinder extends CircularShape implements Shape{

	
	public Cylinder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cylinder(double radius, double height) {
		super(radius, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getSurfaceArea() {
		// TODO Auto-generated method stub
		return getCrossSectionPerimeter()*(getHeight()+getRadius());
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return getCrossSectionPerimeter()*(getRadius()+getHeight())/2.0;
	}
	
	@Override
	public String toString() {
		return "Shape: Cylinder \n Surface Area "+getSurfaceArea() +" \nVolume "+getVolume();
	}

}
