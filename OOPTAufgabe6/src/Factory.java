
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
		Robot robot = getRobot(robotNumber);
		
		if (robot != null) {
			robot.addHoursOperating(hours);
		}
	}
	
	public void addRotations(int robotNumber, int rotations) {			// robotNumber must be a valid SwivelArmRobot
		Robot robot = getRobot(robotNumber);
		
		if (robot != null && robot instanceof SwivelArmRobot) {
			SwivelArmRobot saRobot = (SwivelArmRobot) robot;
			saRobot.addRotations(rotations);
		}
	}
	
	public void addDistance(int robotNumber, double distance) {			// robotNumber must be a valid CrawlerRobot
		Robot robot = getRobot(robotNumber);
		
		if (robot != null && robot instanceof CrawlerRobot) {
			CrawlerRobot cRobot = (CrawlerRobot) robot;
			cRobot.addDistance(distance);
		}
	}
	
	public void setRole(int robotNumber, Role role) {
		Robot robot = getRobot(robotNumber);
		
		if (robot != null) {
			robot.setRole(role);
		}
	}
	
	private Robot getRobot(int number) {
		List.Iterator<Robot> iter = robots.iterator();
		
		while (iter.hasNext()) {
			Robot robot = iter.next();
			if (robot.getNumber() == number) {
				return robot;
			}
		}
		return null;
	}
}
