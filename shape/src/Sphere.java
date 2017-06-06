
public class Sphere implements Shape{
	
	public double radius;
	

	public Sphere(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}
	
	@Override
	public double getSurfaceArea() {
		// TODO Auto-generated method stub
		return 4*Math.PI*radius*radius;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return 4*Math.PI*radius*radius*radius/3;
	}
	
	@Override
	public String toString() {
		return "Shape: Sphere \n Surface Area "+getSurfaceArea() +" \nVolume "+getVolume();
	}
}
