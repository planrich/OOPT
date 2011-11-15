
public abstract class IrregularPolygon implements Polygon {

	protected double [] edges;
	
	public IrregularPolygon(double[] edges) {
		if (edges.length < 3) { // number of edges >= 3
			throw new IllegalArgumentException("Polygon needs at least 3 edges");
		}
		
		for (int i = 0; i < edges.length; i++) {
			if (edges[1] <= 0) {
				throw new IllegalArgumentException("One edge of a polygon is equal or less than 0");
			}
		}
		
		this.edges = edges;
	}

	@Override
	public double perimeter() {
		double perimeter = 0;
		
		for (int i = 0; i < edges.length; i++) {
			perimeter += edges[i];
		}
		
		return perimeter;
	}
	
	@Override
	public int edges() {
		return edges.length;
	}
	
}
