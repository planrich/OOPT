import junit.framework.Assert;

import org.junit.Test;


public class UnitTestFactory {

	@Test
	public void testAddHoursOperating() {
		Factory factory = new Factory("f");
		Robot robot = new SwivelArmRobot(1);
		
		factory.addRobot(robot);
		factory.addHoursOperating(1, 10);
		
		Assert.assertEquals(10, robot.getHoursOperating());
	}
	
	@Test
	public void testAddRotations() {
		Factory factory = new Factory("f");
		SwivelArmRobot robot = new SwivelArmRobot(1);
		
		factory.addRobot(robot);
		factory.addRotations(1, 10);
		
		Assert.assertEquals(10, robot.getRotations());
	}
	
	@Test
	public void testAddDistance() {
		Factory factory = new Factory("f");
		CrawlerRobot robot = new CrawlerRobot(1);
		
		factory.addRobot(robot);
		factory.addDistance(1, 10.5);
		
		Assert.assertEquals(10.5, robot.getDistance());
	}
}
