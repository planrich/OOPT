
public class CrawlerRobot extends Robot {

	private double distance;
	
	public CrawlerRobot(int number) {
		super(number);
		distance = 0;
	}
	
	public void addDistance(double distance) {
		this.distance += distance;
	}

	public double getDistance() {
		return distance;
	}
}
