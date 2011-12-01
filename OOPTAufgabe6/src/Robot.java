
public abstract class Robot {

	private int number;
	private int hoursOperating;
	private Role role;
	
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
	
	public void toWeldingRobot(int temperature) {
		role = new WeldingRobot(temperature);
	}
	
	public void toVarnishRobot(double capacity) {
		role = new VarnishRobot(capacity);
	}
	
	private abstract class Role {
		public abstract double getData();
	}
	
	private class WeldingRobot extends Role {
		private int temperature;
		
		public WeldingRobot(int temperature) {
			this.temperature = temperature;
		}
		
		public int getTemperature() {
			return temperature;
		}
		
		public double getData() {
			return temperature;
		}
	}
	
	private class VarnishRobot extends Role {
		private double capacity;
		
		public VarnishRobot(double capacity) {
			this.capacity = capacity;
		}
		
		public double getCapacity() {
			return capacity;
		}

		public double getData() {
			return capacity;
		}
	}
}
