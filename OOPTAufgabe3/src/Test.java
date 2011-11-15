
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Square s = new Square(3.5);
		s.scale(2.0);
		System.out.println("Area of Square with length 3.5 * 2: " + s.area()); // 
		s.set(1);
		System.out.println("Perimeter of Square with length 1: " + s.perimeter());
		
		RegularPolygon rp = new RegularPolygon(50, 3.8);
		System.out.println("Area of RegularPolygon with 50 sides of length 3.8: " + rp.area());
		
		EquilateralTriangle e = new EquilateralTriangle(4.9);
		System.out.println("Perimeter of EquilateralTriangle with length 4.9: " + e.perimeter());
		
		/*
		Triangle t = new Triangle(3.6, 7.0, 1.2);
		// System.out.println("Trying to scale the Triangle, will not even compile: t.scale(2.5));
		System.out.println("Perimeter of Triangle with lengths 3.6, 7.0, 1.2: " + t.perimeter());
				
		Rectangle rect(8.5, 3.3);
		rect.scale(0.5);
		System.out.println("Area of Rectangle with lengths a and b: 8.5*0.5, 3.3*0.5: " + rect.area());
		*/
	}
}
