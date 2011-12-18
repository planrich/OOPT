
public class WildBoarHunter extends Worker {
	
	public WildBoarHunter(int workIterations, long duration) {
		super(workIterations, duration);
	}

	@Override
	protected void afterWork() throws InterruptedException {
		CoolingWareHouse.instance().addWare(1);
		System.out.println("Added a boar.");
	}

	@Override
	protected void beforeWork() throws InterruptedException {
		// do nothing
	}
}
