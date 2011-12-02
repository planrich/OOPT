
public class Test {

	public static void main(String[] args) {
		
		System.out.println("\nAdding Factories...");
		
		List<Factory> factories = new List<Factory>();
		
		Factory simons = new Factory("Simons Factory");
		Factory klausis = new Factory("Klaus Factory");
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
			
		System.out.println("Status of: " + simons.getName());
		System.out.println("Average Hours Worked: " + simons.getAverageHours());
	}
}
