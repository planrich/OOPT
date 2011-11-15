
public class Rectangle extends IrregularPolygon implements Scaleable { //rectangle is scaleable but not triangle

	public Rectangle(double a, double b) {
		super(new double[] { a, b, a, b }); // length >= 3
	}

	@Override
	public double area() {
		return edges[0] * edges[1];
	}

	@Override
	public double perimeter() {
		return (edges[0] + edges[1] + edges[2] + edges[3]);
	}

	@Override
	public void scale(double factor) { // factor > 0
		if (factor > 0) {
			for (int i = 0; i < edges.length; i++) {
				edges[i] = edges[i] * factor;
			}
		}
	}
}
