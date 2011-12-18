import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		List<Worker> workers = new ArrayList<Worker>();
		
		WildBoarHunter hunter1 = new WildBoarHunter(5, 10);
		WildBoarHunter hunter2 = new WildBoarHunter(5, 20);
		workers.add(hunter1);
		workers.add(hunter2);
		
		Cook cook = new Cook(30);
		workers.add(cook);
		
		WoodCutter cutter1 = new WoodCutter(20);
		WoodCutter cutter2 = new WoodCutter(20);
		WoodCutter cutter3 = new WoodCutter(20);
		WoodCutter cutter4 = new WoodCutter(20);
		WoodCutter cutter5 = new WoodCutter(20);
		workers.add(cutter1);
		workers.add(cutter2);
		workers.add(cutter3);
		workers.add(cutter4);
		workers.add(cutter5);
		
		Logistician log1 = new Logistician(30);
		Logistician log2 = new Logistician(30);
		workers.add(log1);
		workers.add(log2);
		
		for (Worker worker : workers) {
			worker.start();
		}
		
		try { Thread.sleep(3000); }
		catch (InterruptedException ex) {}
		
		System.out.println("Business is not going good, killing all workers ...");
		for (Worker worker : workers) {
			worker.interrupt();
		}
		
		System.out.println("Wildboars: " + CoolingWareHouse.instance().getWareCount());
		System.out.println("Wildboar Meals: " + Table.instance().getWareCount());
		System.out.println("Trees: " + StoneQuarry.instance().getWareCount());
		System.out.println("Ochsen Karren: " + CivicCenter.instance().getWareCount());
	}
}
