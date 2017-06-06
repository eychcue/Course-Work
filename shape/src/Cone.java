
public class Cone extends CircularShape implements Shape{
	
	
	public Cone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cone(double radius, double height) {
		super(radius, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getSurfaceArea() {
		// TODO Auto-generated method stub
		return Math.PI*getRadius()*(getRadius()*getRadius()+getHeight()*getHeight());
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return getCrossSectionPerimeter()*getHeight()/3.0;
	}
	@Override
	public String toString() {
		return "Shape: Cone \n Surface Area "+getSurfaceArea() +" \nVolume "+getVolume();
	}
	

}
