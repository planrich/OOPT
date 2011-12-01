
public class Factory {
	
	private String name;
	private List<Robot> robots;
	
	public Factory(String name) {				// not null
		this.name = name;
		this.robots = new List<Robot>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addRobot(Robot robot) {			// not null
		robots.add(robot);
	}
	
	public void removeRobot(Robot robot) {		// not null
		robots.remove(robot);
	}
	
	public void addHoursOperating(int robotNumber, int hours) {
		List.Iterator<Robot> iter = robots.iterator();
		
		while (iter.hasNext()) {
			Robot robot = iter.next();
			if (robot.getNumber() == robotNumber) {
				robot.addHoursOperating(hours);
				return;
			}
		}
	}
}
