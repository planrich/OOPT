public class Factory {

	private String name;
	private List<Robot> robots;

	public Factory(String name) { // not null
		this.name = name;
		this.robots = new List<Robot>();
	}

	public String getName() {
		return name;
	}

	public void addRobot(Robot robot) { // not null
		robots.add(robot);
	}

	public void removeRobot(int id) {
		Robot robot = getRobot(id);
		if (robot != null) {
			robots.remove(robot);
		}
	}

	public void addHoursOperating(int robotNumber, int hours) {
		Robot robot = getRobot(robotNumber);

		if (robot != null) {
			robot.addHoursOperating(hours);
		}
	}

	public void addRotations(int robotNumber, int rotations) { // robotNumber
																// must be a
																// valid
																// SwivelArmRobot
		Robot robot = getRobot(robotNumber);

		if (robot != null && robot instanceof SwivelArmRobot) {
			SwivelArmRobot saRobot = (SwivelArmRobot) robot;
			saRobot.addRotations(rotations);
		}
	}

	public void addDistance(int robotNumber, double distance) { // robotNumber
																// must be a
																// valid
																// CrawlerRobot
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

	private List<Robot> filterCrawlers(List<Robot> from) {
		List.Iterator<Robot> iter = from.iterator();
		List<Robot> list = new List<Robot>();

		while (iter.hasNext()) {
			Robot robot = iter.next();
			if (robot instanceof CrawlerRobot) {
				list.add(robot);
			}
		}

		return list;
	}
	
	private List<Robot> filterSwivel(List<Robot> from) {
		List.Iterator<Robot> iter = from.iterator();
		List<Robot> list = new List<Robot>();

		while (iter.hasNext()) {
			Robot robot = iter.next();
			if (robot instanceof SwivelArmRobot) {
				list.add(robot);
			}
		}

		return list;
	}
	
	private List<Robot> filterVarnish(List<Robot> from) {
		List.Iterator<Robot> iter = from.iterator();
		List<Robot> list = new List<Robot>();
		
		while (iter.hasNext()) {
			Robot robot = iter.next();
			if (robot.getRole() instanceof VarnishRobot) {
				list.add(robot);
			}
		}

		return list;
	}
	
	private List<Robot> filterWelding(List<Robot> from) {
		List.Iterator<Robot> iter = from.iterator();
		List<Robot> list = new List<Robot>();

		while (iter.hasNext()) {
			Robot robot = iter.next();
			if (robot.getRole() instanceof WeldingRobot) {
				list.add(robot);
			}
		}

		return list;
	}
	
	/**
	 * if count is 0 then 0 is returned. it does not make sense to give back NaN 
	 * @param from
	 * @return 0 if there would occur a division through 0, sum / count otherwise
	 */
	private double getAverageHours(List<Robot> from) {
		List.Iterator<Robot> iter = from.iterator();
		int sum = 0;
		int count = 0;

		while (iter.hasNext()) {
			Robot robot = iter.next();
			count++;
			sum += robot.getHoursOperating();
		}
		
		if (count == 0) {
			return 0;
		}

		return sum / count;
	}
	
	public double getAverageHours() {
		return getAverageHours(robots);
	}

	public double getAverageHoursWelding() {
		return getAverageHours(filterWelding(robots));
	}
	
	public double getAverageHoursVarnish() {
		return getAverageHours(filterVarnish(robots));
	}
	
	public double getAverageHoursCrawler() {
		return getAverageHours(filterCrawlers(robots));
	}
	
	public double getAverageHoursSwivel() {
		return getAverageHours(filterSwivel(robots));
	}
	
	/**
	 * @param from
	 * @return 0 iff count == 0, sum / count otherwise
	 */
	private double getAverageRotations(List<Robot> from) {
		List.Iterator<Robot> iter = from.iterator();
		int sum = 0;
		int count = 0;

		while (iter.hasNext()) {
			Robot robot = iter.next();
			if (robot instanceof SwivelArmRobot) {
				count++;
				sum += ((SwivelArmRobot)robot).getRotations();
			}
		}
		
		if (count == 0) {
			return 0;
		}

		return sum / count;
	}
	
	public double getAverageRotations() {
		return getAverageRotations(robots);
	}
	
	public double getAverageRotationsVarnish() {
		return getAverageRotations(filterVarnish(robots));
	}
	
	public double getAverageRotationsWelding() {
		return getAverageRotations(filterWelding(robots));
	}
	
	/**
	 * Average distance == NaN does not make sense
	 * @param from
	 * @return 0 if count is 0, sum / count otherwise
	 */
	private double getAverageDistance(List<Robot> from) {
		List.Iterator<Robot> iter = from.iterator();
		double sum = 0;
		int count = 0;

		while (iter.hasNext()) {
			Robot robot = iter.next();
			if (robot instanceof CrawlerRobot) {
				count++;
				sum += ((CrawlerRobot)robot).getDistance();
			}
		}
		
		if (count == 0) {
			return 0;
		}

		return sum / count;
	}
	
	public double getAverageDistance() {
		return getAverageDistance(robots);
	}
	
	public double getAverageDistanceVarnish() {
		return getAverageDistance(filterVarnish(robots));
	}
	
	public double getAverageDistanceWelding() {
		return getAverageDistance(filterWelding(robots));
	}
	
	private int getTemperature(List<Robot> from, boolean max) {
		List.Iterator<Robot> iter = from.iterator();
		int extreme = max ? Integer.MIN_VALUE : Integer.MAX_VALUE;

		while (iter.hasNext()) {
			Robot robot = iter.next();
			if (robot.getRole() instanceof WeldingRobot) {
				if (max && robot.getRole().getData() > extreme) {
					extreme = (int)robot.getRole().getData();
				} else if (!max && robot.getRole().getData() < extreme) {
					extreme = (int)robot.getRole().getData();
				}
			}
		}

		return extreme;
	}
	
	public int getTemperature(boolean max) {
		return getTemperature(robots,max);
	}

	public int getTemperatureCrawler(boolean max) {
		return getTemperature(filterCrawlers(robots),max);
	}
	
	public int getTemperatureSwivel(boolean max) {
		return getTemperature(filterSwivel(robots),max);
	}

}
