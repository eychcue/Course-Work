
public class RectanglePrism implements Shape{
	
	double length;
	double height;
	double width;
	

	public RectanglePrism() {
		this.length = 0.0;
		this.height = 0.0;
		this.width = 0.0;
	}

	public RectanglePrism(double length, double height, double width) {
		this.length = length;
		this.height = height;
		this.width = width;
	}

	@Override
	public double getSurfaceArea() {
		// TODO Auto-generated method stub
		return 2.0*(length*height+height*width+length*width);
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return length*height*width;
	}
	
	@Override
	public String toString() {
		return "Shape: Rectangle Prism \n Surface Area "+getSurfaceArea() +" \nVolume "+getVolume();
	}
	

}
