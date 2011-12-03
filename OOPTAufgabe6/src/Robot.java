
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
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Role getRole() {
		return role;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Robot) {
			Robot robot = (Robot) obj;
			return robot.number == this.number;
		}
		return false;
	}
}
