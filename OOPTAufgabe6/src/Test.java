
public class Test {

	public static void main(String[] args) {
		
		List<Factory> factories = new List<Factory>();
		factories.add(new Factory("Simons Factory"));
		factories.add(new Factory("Richards Factory"));
		factories.add(new Factory("Klaus Factory"));
		
		List.Iterator<Factory> fact_iter = factories.iterator();
		
		System.out.println("Factories available: ");
		while(fact_iter.hasNext()) {
			Factory f = fact_iter.next();
			System.out.println("- " + f.getName());
		}
		
		System.out.println("\nAdding Robots to Simons Factory...");
		
		fact_iter = factories.iterator();
		if(fact_iter.hasNext()) {
			
			Factory fact = fact_iter.next();
			CrawlerRobot crawler1 = new CrawlerRobot(2);
			CrawlerRobot crawler2 = new CrawlerRobot(5);
			SwivelArmRobot swivelarm1 = new SwivelArmRobot(9);
			
			fact.addRobot(crawler1);
			fact.addRobot(crawler2);
			fact.addRobot(swivelarm1);

			fact.addHoursOperating(2, 100);
			fact.addHoursOperating(5, 200);
			fact.addHoursOperating(9, 300);
			
			fact.addRotations(2, 6800);
			fact.addRotations(5, 4700);
			fact.addRotations(9, 9844);
			
			fact.setRole(2, new VarnishRobot(2));
			fact.setRole(5, new VarnishRobot(2));
			fact.setRole(9, new WeldingRobot(2));
			
			
			System.out.println("Status of: " + fact.getName());
			System.out.println("Average Hours Worked: " + fact.getAverageHours());
			
		}
	}
}
