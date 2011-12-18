
public class WildBoarHunter extends Worker {
	
	public WildBoarHunter(int workIterations, long duration) {
		super(workIterations, duration);
	}

	@Override
	protected void doWork() throws InterruptedException {
		synchronized (CoolingWareHouse.instance().addingLock) {
			while (!CoolingWareHouse.instance().addWildBoar()) {
				System.out.println("Waiting now ...");
				CoolingWareHouse.instance().addingLock.wait();
			}
			System.out.println("Added a boar.");
		}
	}
}
