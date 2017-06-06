
public abstract class PrismTriangle {
	
	double altitude;
	double base;
	double side1;
	double side2;
	double side3;
	double height;
	
	
	public PrismTriangle() {
		this.altitude = 0.0;
		this.base = 0.0;
		this.side1 = 0.0;
		this.side2 = 0.0;
		this.side3 = 0.0;
	}
	
	public PrismTriangle(double altitude, double base, double side1, double side2, double side3) {
		this.altitude = altitude;
		this.base = base;
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public PrismTriangle(double altitude, double base, double side1, double side2, double side3, double height) {
		this.altitude = altitude;
		this.base = base;
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.height = height;
		// TODO Auto-generated constructor stub
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getBaseArea(){
		return altitude*base/2.0;
	}
	
	public double getPerimeter(){
		return (side1+side2+side3);
	}
	
	

}
