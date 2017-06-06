
public abstract class CircularShape {
	
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
