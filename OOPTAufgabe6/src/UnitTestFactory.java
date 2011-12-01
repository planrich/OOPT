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
}
