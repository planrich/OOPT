
public abstract class Robot {

	private int number;
	private int hoursOperating;
	
	public Robot(int number) {					// must be unique
		this.number = number;
		this.hoursOperating = 0;
	}
	
	public void addHoursOperating(int hours) {	// must be > 0
		this.hoursOperating += hours;
	}
	
	public int getHoursOperating() {
		return hoursOperating;
	}
	
	public int getNumber() {
		return number;
	}
}
