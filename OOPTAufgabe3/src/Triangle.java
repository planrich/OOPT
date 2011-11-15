
public class Triangle extends IrregularPolygon {

	public Triangle(double a, double b, double c) {
		super(new double[] { a, b, c });
	}
	
	@Override
	public double area() {
		double s = (edges[0] + edges[1] + edges[2]) / 2;
		return Math.sqrt(s * (s - edges[0]) * (s - edges[1]) * (s - edges[2]));
	}

	@Override
	public double perimeter() {
		return edges[0] + edges[1] + edges[2];
	}
	
	public void setA(double a) {
		edges[0] = a;
	}
	
	public void setB(double b) {
		edges[1] = b;
	}
	
	public void setC(double c) {
		edges[2] = c;
	}	
}
