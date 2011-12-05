public class Test {

	public static void main(String[] args) {

		/*
		 * TODO
		 * Erstellen Sie eine Menge von Fabriken von jeweils einigen Robotern – wirklich eine Menge von Fabriken (eine Form von Collection) ...
		 * __Jede Fabrik in der Menge soll über ihren eindeutigen Namen angesprochen werden können__ ...
		 * 
		 */
		
		System.out.println("NOTE:");
		System.out.println("divisions by zero are caught automatically, so they just return 0 instead of throwing an exception. this is very likely to happen at klaus factory.");
		System.out.println();
		
		System.out.println("Creating factories");

		FactoryList factories = new FactoryList();

		Factory simons = new Factory("Simons Factory");
		Factory klausis = new Factory("Klaus Factory"); // hat 0 Roboter -> Fuer
														// division durch 0
														// tests
		Factory richards = new Factory("Richards Factory");

		factories.add(simons);
		factories.add(klausis);
		factories.add(richards);

		List.Iterator factoryIter = factories.iterator();

		System.out.println("Factories available: ");
		while (factoryIter.hasNext()) {
			Factory f = (Factory) factoryIter.next();
			System.out.println("- " + f.getName());
		}

		System.out.println();
		System.out.println("#########################");
		System.out.println("Robots operations:");
		System.out.println("#########################");
		System.out.println();
		
		System.out.println("adding robots");
		
		richards.addRobot(new SwivelArmRobot(9));
		richards.addRobot(new SwivelArmRobot(19));
		richards.addRobot(new CrawlerRobot(666));
		richards.addRobot(new CrawlerRobot(667));
		richards.addRobot(new CrawlerRobot(668));

		simons.addRobot(new CrawlerRobot(2));
		simons.addRobot(new CrawlerRobot(5));
		simons.addRobot(new SwivelArmRobot(9));
		
		System.out.println("changing operationhours, rotations, distances and equipting robots");

		simons.addHoursOperating(2, 100);
		simons.addHoursOperating(5, 200);
		simons.addHoursOperating(9, 300);

		simons.addRotations(2, 6800);
		simons.addRotations(5, 4700);
		simons.addRotations(9, 9844);

		simons.setRole(2, new VarnishRobot(2));
		simons.setRole(5, new VarnishRobot(2));
		simons.setRole(9, new WeldingRobot(2));
		
		richards.setRole(12, new VarnishRobot(88)); // does nothing at all

		richards.setRole(9, new VarnishRobot(9));
		richards.setRole(19, new WeldingRobot(19));

		richards.setRole(666, new WeldingRobot(666));
		richards.setRole(667, new WeldingRobot(220));
		richards.setRole(668, new VarnishRobot(101));
		
		richards.addDistance(666, 666.666);
		richards.addDistance(667, 666666.66);
		richards.addDistance(668, 3.9);
		
		richards.addHoursOperating(19, -20);
		richards.addHoursOperating(9, -9000);
		richards.addHoursOperating(33, 800); // a non-existent robot
		richards.addHoursOperating(666, 6666666);

		richards.addRotations(9, -20);
		richards.addRotations(19, -40);
		richards.addRotations(33, 8); // a non-existent robot

		System.out.println("removing 2 robots");
		simons.removeRobot(2);
		richards.removeRobot(19);

		System.out.println();
		System.out.println("#########################");
		System.out.println("Factory specific statistics:");
		System.out.println("#########################");
		System.out.println();
		
		
		factoryIter = factories.iterator();
		int min_temp = Integer.MAX_VALUE;
		int max_temp = Integer.MIN_VALUE;
		int min_temp_crawler = Integer.MAX_VALUE;
		int min_temp_swivel = Integer.MIN_VALUE;
		int max_temp_crawler = Integer.MAX_VALUE;
		int max_temp_swivel = Integer.MIN_VALUE;

		double avgdistance = 0;
		int distancecount = 0;
		double avgdistance_welding = 0;
		int welding_distancecount = 0;
		double avgdistance_varnish = 0;
		int varnish_distancecount = 0;

		while (factoryIter.hasNext()) {
			Factory f = (Factory) factoryIter.next();

			System.out.println();
			System.out.println("-------------------------------------");
			System.out.println(f.getName() + ":");
			System.out.println("-------------------------------------");

			System.out.println("avg hours worked: " + f.getAverageHours());
			System.out.println("avg hours worked (Crawler): "
					+ f.getAverageHoursCrawler());
			System.out.println("avg hours worked (Swivel): "
					+ f.getAverageHoursSwivel());
			System.out.println("avg hours worked (Varnish): "
					+ f.getAverageHoursVarnish());
			System.out.println("avg hours worked (Welding): "
					+ f.getAverageHoursWelding());

			System.out.println();

			System.out.println("avg rotations: " + f.getAverageRotations());
			System.out.println("avg rotations (Varnish): "
					+ f.getAverageRotationsVarnish());
			System.out.println("avg rotations (Welding): "
					+ f.getAverageRotationsWelding());

			System.out.println();

			double avg = f.getAverageDistance();
			System.out.println("avg distance: " + avg);
			avgdistance += avg;
			distancecount++;

			avg = f.getAverageDistanceVarnish();
			System.out.println("avg distance (Varnish): " + avg);
			avgdistance_varnish += avg;
			varnish_distancecount++;

			avg = f.getAverageDistanceWelding();
			System.out.println("avg distance (Welding): " + avg);
			avgdistance_welding += avg;
			welding_distancecount++;

			int min = f.getTemperature(false);
			int max = f.getTemperature(true);
			int min_swivel = f.getTemperatureSwivel(false);
			int max_swivel = f.getTemperatureSwivel(true);
			int min_crawler = f.getTemperatureCrawler(false);
			int max_crawler = f.getTemperatureCrawler(true);

			if (min < min_temp) {
				min_temp = min;
			}
			if (max > max_temp) {
				max_temp = max;
			}

			if (min_swivel < min_temp_swivel) {
				min_temp_swivel = min_swivel;
			}
			if (max_swivel > max_temp_swivel) {
				max_temp_swivel = max_swivel;
			}

			if (min_crawler < min_temp_crawler) {
				min_temp_crawler = min_crawler;
			}
			if (max_crawler < max_temp_crawler) {
				max_temp_crawler = max_crawler;
			}
		}

		/*
		 * Die minimale und maximale Arbeitstemperatur aller Schweißroboter
		 * insgesamt und aufgeschlüsselt nach Robotertyp (Schwenkarmroboter oder
		 * Raupenroboter). 
		 * 
		 * ==> not factory specific
		 * 
		 * Die durchschnittlich zurückgelegte Wegstrecke aller
		 * Raupenroboter insgesamt und aufgeschlüsselt nach Robotertyp.
		 * 
		 * ==> not factory specific
		 * 
		 * calculated in loop above and printed out here
		 */
		System.out.println();
		System.out.println("#########################");
		System.out.println("Statistics over all factories:");
		System.out.println("#########################");
		System.out.println();
		System.out
				.println("Temp (if there is no welding robot, int.min / max is printed depending on min or max):");

		System.out.println("min temp over entire factories: " + min_temp);
		System.out.println("max temp over entire factories: " + max_temp);

		System.out.println("min temp over entire factories (Swivel): "
				+ min_temp_swivel);
		System.out.println("max temp over entire factories (Swivel): "
				+ max_temp_swivel);

		System.out.println("min temp over entire factories (Crawler): "
				+ min_temp_crawler);
		System.out.println("max temp over entire factories (Crawler): "
				+ max_temp_crawler);

		System.out.println();
		System.out.println("Avg distance:");
		System.out.println("Avg distance of all robots: " + avgdistance
				/ distancecount);
		System.out.println("Avg distance of all varnish robots: "
				+ avgdistance_varnish / varnish_distancecount);
		System.out.println("Avg distance of all welding robots: "
				+ avgdistance_welding / welding_distancecount);
		
		
		String name = "Richards Factory";
		Factory myFactory = factories.getByName(name);

		System.out.println();
		System.out.println("#########################");
		System.out.println("Hours-worked Factory statistics");
		System.out.println("for the Factory named '" + name + "'");
		System.out.println("#########################");
		System.out.println();
		
		if(myFactory != null) {
			System.out.println("avg hours worked: " + myFactory.getAverageHours());
			System.out.println("avg hours worked (Crawler): "
					+ myFactory.getAverageHoursCrawler());
			System.out.println("avg hours worked (Swivel): "
					+ myFactory.getAverageHoursSwivel());
			System.out.println("avg hours worked (Varnish): "
					+ myFactory.getAverageHoursVarnish());
			System.out.println("avg hours worked (Welding): "
					+ myFactory.getAverageHoursWelding());
	
			System.out.println();
		} else {
			System.out.println("Factory with name " + name + " does not exist!");
		}
	}
}
