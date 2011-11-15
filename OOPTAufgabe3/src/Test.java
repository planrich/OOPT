
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("-> Testing RegularPolygons:");
		RegularPolygon rp = new Square(3.5);
		rp.scale(2.0);
		System.out.println("Area of square with length 3.5 * 2: " + rp.area());
		rp.set(1);
		System.out.println("Perimeter of square with length 1: " + rp.perimeter());
		
		Polygon p = new RegularPolygon(50, 3.8);
		System.out.println("Area of RegularPolygon with 50 sides of length 3.8: " + p.area());
		
		p = new EquilateralTriangle(4.9);
		System.out.println("Perimeter of EquilateralTriangle with length 4.9: " + p.perimeter());
		
		p = new Triangle(3.6, 7.0, 1.2);
		System.out.println("generating a triangle");
		System.out.println("Trying to scale the Triangle, will not even compile: p.scale(2.5)");
		System.out.println("Perimeter of Triangle with lengths 3.6, 7.0, 1.2: " + p.perimeter());
				
		System.out.println("-> Testing IrregularPolygon:");
		
		Rectangle r = new Rectangle(8.5, 3.3);
		r.scale(0.5);
		System.out.println("Area of Rectangle with lengths a and b: 8.5*0.5, 3.3*0.5: " + r.area());
		
	}
}
