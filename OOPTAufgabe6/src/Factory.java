
public class Factory {
	
	private String name;
	private List<Robot> robots;
	
	public Factory(String name) {		// not null
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addRobot(Robot robot) {
		robots.add(robot);
	}
	
	public void removeRobot(Robot robot) {
		robots.remove(robot);
	}
}
