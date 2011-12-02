
public class Test {

	public static void main(String[] args) {
		
		System.out.println("\nAdding Factories...");
		
		List<Factory> factories = new List<Factory>();
		
		Factory simons = new Factory("Simons Factory");
		Factory klausis = new Factory("Klaus Factory"); // hat 0 Roboter -> FŸr division durch 0 tests
		Factory richards = new Factory("Richards Factory");
		
		factories.add(simons);
		factories.add(klausis);
		factories.add(richards);
		
		List.Iterator<Factory> fact_iter = factories.iterator();
		
		System.out.println("Factories available: ");
		while(fact_iter.hasNext()) {
			Factory f = fact_iter.next();
			System.out.println("- " + f.getName());
		}
		
		System.out.println("\nAdding Robots to Simons Factory...");
		
		CrawlerRobot crawler1 = new CrawlerRobot(2);
		CrawlerRobot crawler2 = new CrawlerRobot(5);
		SwivelArmRobot swivelarm1 = new SwivelArmRobot(9);
			
		simons.addRobot(crawler1);
		simons.addRobot(crawler2);
		simons.addRobot(swivelarm1);
		
		simons.addHoursOperating(2, 100);
		simons.addHoursOperating(5, 200);
		simons.addHoursOperating(9, 300);
			
		simons.addRotations(2, 6800);
		simons.addRotations(5, 4700);
		simons.addRotations(9, 9844);
			
		simons.setRole(2, new VarnishRobot(2));
		simons.setRole(5, new VarnishRobot(2));
		simons.setRole(9, new WeldingRobot(2));
		
		System.out.println("\nAdding Robots to Richards Factory...");
		richards.addRobot(new SwivelArmRobot(9));
		richards.addRobot(new SwivelArmRobot(19));
		
		System.out.println("\nTrying to change roles of Robots that do not exist...");
		richards.setRole(6, new WeldingRobot(6));
		richards.setRole(12, new VarnishRobot(88));
		
		richards.setRole(9, new VarnishRobot(9));
		richards.setRole(19, new WeldingRobot(19));
		
		System.out.println("\nTrying to set operating Hours to a negative value...");
		richards.addHoursOperating(19, -20);
		richards.addHoursOperating(9, -9000);
		richards.addHoursOperating(33, 800); // a non-existent robot
		
		System.out.println("\nTrying to set rotations to a negative value...");
		
		richards.addRotations(9, -20);
		richards.addRotations(19, -40);
		richards.addRotations(33, 8); //a non-existent robot
		
		fact_iter = factories.iterator();
		while(fact_iter.hasNext()) {
			Factory f = fact_iter.next();
			System.out.println("Status of: " + f.getName());
			System.out.println("Average Hours Worked: " + f.getAverageHours());
			System.out.println("\n");
		}
		
		
	}
}
