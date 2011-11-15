
public class RegularPolygon implements Polygon, Scaleable {

	protected double length;
	protected int count;

	public RegularPolygon(int count, double length) {
		if (count < 3 || length <= 0) {
			throw new IllegalArgumentException("Arguments are wrong.");
		}
		this.count = count;
		this.length = length;
	}
	
	@Override
	public void scale(double factor) {
		if (factor > 0) {
			length *= factor;
		} else {
			// do nothing
		}
	}

	@Override
	public int edges() {
		return count;
	}

	@Override
	public double area() {
		double area = count * length * length / (4 * Math.tan(Math.PI / count));
		return area;
	}

	@Override
	public double perimeter() {
		double perimeter = count * length;
		return perimeter;
	}
	
	public void set(double length) {
		this.length = length;
	}
}
