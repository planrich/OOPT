import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		List<Worker> workers = new ArrayList<Worker>();

		initWorkers(workers, 0);

		for (Worker worker : workers) {
			worker.start();
		}

		try {
			Thread.sleep(100);
		} catch (InterruptedException ex) {
		}

		System.out.println();
		System.out
				.println("Business is not going good, killing all workers ...");
		for (Worker worker : workers) {
			worker.interrupt();
		}

		for (Worker worker : workers) {
			worker.printHarvestCount();
		}

		System.out.println();

		System.out.println("Wildboars: "
				+ CoolingWareHouse.instance().getWareCount());
		System.out
				.println("Wildboar Meals: " + Table.instance().getWareCount());
		System.out.println("Trees: " + StoneQuarry.instance().getWareCount());
		System.out.println("Ochsen Karren: "
				+ CivicCenter.instance().getWareCount());

		System.out.println();
		System.out.println();

		System.out.println("Business was not that bad... starting again");

		for(int i = 0; i < 3; i++) {
			
			System.out.println("Beginning Business Run Number " + (i+1) + ":");
			workers.clear();
			initWorkers(workers, i);
	
			for (Worker worker : workers) {
				worker.start();
			}
	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
	
			System.out.println();
			System.out
					.println("Work should be done now! check if there is anyone still working...");
			int interrupted = 0;
			for (Worker worker : workers) {
				if (!worker.getState().equals(Thread.State.TERMINATED)) {
					System.out.println(worker.getClass().getSimpleName()
							+ " still working -> interrupt()");
					worker.interrupt();
					interrupted ++;
				}
			}
			
			if (interrupted > 0) {
				System.out.println("Still there are some people working!");
			} else {
				System.out.println("Lazy bastards... nobody working anymore");
			}
	
			for (Worker worker : workers) {
				worker.printHarvestCount();
			}
	
			System.out.println();
	
			System.out.println("Wildboars: "
					+ CoolingWareHouse.instance().getWareCount());
			System.out
					.println("Wildboar Meals: " + Table.instance().getWareCount());
			System.out.println("Trees: " + StoneQuarry.instance().getWareCount());
			System.out.println("Ochsen Karren: "
					+ CivicCenter.instance().getWareCount());
	
			System.out.println();
			System.out.println();
		}
	}

	/**
	 * 
	 * @param workers list of workers
	 * @param iteration number of iteration to initialize for
	 */
	private static void initWorkers(List<Worker> workers, int iteration) {
		
		if (iteration == 0) {
			
			WildBoarHunter hunter1 = new WildBoarHunter(5, 2);
			WildBoarHunter hunter2 = new WildBoarHunter(5, 4);
			workers.add(hunter1);
			workers.add(hunter2);
	
			CoolingWareHouse.instance().add(hunter1);
			CoolingWareHouse.instance().add(hunter2);
	
			Cook cook = new Cook(30);
			workers.add(cook);
	
			Table.instance().add(cook);
	
			WoodCutter cutter1 = new WoodCutter(12);
			WoodCutter cutter2 = new WoodCutter(14);
			WoodCutter cutter3 = new WoodCutter(16);
			WoodCutter cutter4 = new WoodCutter(18);
			WoodCutter cutter5 = new WoodCutter(20);
			workers.add(cutter1);
			workers.add(cutter2);
			workers.add(cutter3);
			workers.add(cutter4);
			workers.add(cutter5);
	
			StoneQuarry.instance().add(cutter1);
			StoneQuarry.instance().add(cutter2);
			StoneQuarry.instance().add(cutter3);
			StoneQuarry.instance().add(cutter4);
			StoneQuarry.instance().add(cutter5);
	
			Logistician log1 = new Logistician(12);
			Logistician log2 = new Logistician(33);
			workers.add(log1);
			workers.add(log2);
			
		} else if (iteration == 1) {
			
			WildBoarHunter hunter1 = new WildBoarHunter(6, 11);
			WildBoarHunter hunter2 = new WildBoarHunter(6, 44);
			workers.add(hunter1);
			workers.add(hunter2);
	
			CoolingWareHouse.instance().setMaxCount(9);
			CoolingWareHouse.instance().add(hunter1);
			CoolingWareHouse.instance().add(hunter2);
	
			Cook cook = new Cook(35);
			workers.add(cook);
	
			Table.instance().setMaxCount(8);
			Table.instance().add(cook);
	
			WoodCutter cutter1 = new WoodCutter(1);
			WoodCutter cutter2 = new WoodCutter(3);
			WoodCutter cutter3 = new WoodCutter(5);
			WoodCutter cutter4 = new WoodCutter(8);
			WoodCutter cutter5 = new WoodCutter(13);
			workers.add(cutter1);
			workers.add(cutter2);
			workers.add(cutter3);
			workers.add(cutter4);
			workers.add(cutter5);
	
			StoneQuarry.instance().setMaxCount(7);
			StoneQuarry.instance().add(cutter1);
			StoneQuarry.instance().add(cutter2);
			StoneQuarry.instance().add(cutter3);
			StoneQuarry.instance().add(cutter4);
			StoneQuarry.instance().add(cutter5);
	
			Logistician log1 = new Logistician(20);
			Logistician log2 = new Logistician(30);
			workers.add(log1);
			workers.add(log2);
			
		} else {
			
			WildBoarHunter hunter1 = new WildBoarHunter(3, 9);
			WildBoarHunter hunter2 = new WildBoarHunter(3, 4);
			workers.add(hunter1);
			workers.add(hunter2);
	
			CoolingWareHouse.instance().setMaxCount(7);
			CoolingWareHouse.instance().add(hunter1);
			CoolingWareHouse.instance().add(hunter2);
	
			Cook cook = new Cook(77);
			workers.add(cook);
	
			Table.instance().setMaxCount(17);
			Table.instance().add(cook);
	
			WoodCutter cutter1 = new WoodCutter(4);
			WoodCutter cutter2 = new WoodCutter(8);
			WoodCutter cutter3 = new WoodCutter(16);
			WoodCutter cutter4 = new WoodCutter(32);
			WoodCutter cutter5 = new WoodCutter(64);
			workers.add(cutter1);
			workers.add(cutter2);
			workers.add(cutter3);
			workers.add(cutter4);
			workers.add(cutter5);
	
			StoneQuarry.instance().setMaxCount(16);
			StoneQuarry.instance().add(cutter1);
			StoneQuarry.instance().add(cutter2);
			StoneQuarry.instance().add(cutter3);
			StoneQuarry.instance().add(cutter4);
			StoneQuarry.instance().add(cutter5);
	
			Logistician log1 = new Logistician(12);
			Logistician log2 = new Logistician(13);
			workers.add(log1);
			workers.add(log2);
		}
	}
}
