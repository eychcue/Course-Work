
public class Driver {

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
