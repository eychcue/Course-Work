
public interface Shape {

	public double getSurfaceArea();
	public double getVolume();

}

class Cube implements Shape{
	
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

class Sphere implements Shape{
	
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

class RectanglePrism implements Shape{
	
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

class Cone extends CircularShape implements Shape{
	
	
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

class Cylinder extends CircularShape implements Shape{

	
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

abstract class CircularShape {
	
	double height;
	double radius;
	

	public CircularShape() {
		this.radius = 0.0;
		this.height = 0.0;
	}
	
	public CircularShape(double radius) {
		this.radius = radius;
	}
	
	public CircularShape(double radius, double height) {
		this.radius = radius;
		this.height = height;
		// TODO Auto-generated constructor stub
	}

	public double getRadius() {
		return radius;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getCrossSectionArea(){
		return (radius*radius*4.0*Math.PI);
	}
	
	public double getCrossSectionPerimeter(){
		return (2.0*Math.PI*radius);
	}
	
	

}

abstract class PrismTriangle {
	
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


class TrianglePrism extends PrismTriangle implements Shape{

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

class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int MAX = 6;
		
		Shape[] shapes = new Shape[MAX];
		
		shapes[0] = new Cube(10);
		
		System.out.println(shapes[0]);
		
		shapes[1] = new RectanglePrism(5.0,10.0,15.0);
		
		System.out.println(shapes[1]);
		
		shapes[2] = new Sphere(10);
		
		System.out.println(shapes[2]);
		
		shapes[3] = new TrianglePrism(5.0,1.0,1.0,2.0,3.0,15.0);
		
		System.out.println(shapes[3]);
		
		shapes[4] = new Cone(2.0,3.0);
		
		System.out.println(shapes[4]);
		
		shapes[5] = new Cylinder(3.0,4.0);
		
		System.out.println(shapes[5]);
	

	}

}
