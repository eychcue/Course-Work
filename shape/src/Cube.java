
public class Cube implements Shape{
	
	private double side;
	
	public Cube(double side){
		this.side =side;
	}
	@Override
	public double getSurfaceArea() {
		// TODO Auto-generated method stub
		return side*side*side;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return 6*side*side;
	}
	@Override
	public String toString() {
		return "Shape: Cube \n Surface Area "+getSurfaceArea() +" \nVolume "+getVolume();
	}

}
