
public class WildBoarHunter extends Worker {
	
	public WildBoarHunter(int workIterations, long duration) {
		super(workIterations, duration);
	}

	@Override
	protected void afterWork() throws InterruptedException {
		CoolingWareHouse.instance().addWare(1);
		++farmCount;
		System.out.println("Added a boar.");
	}

	@Override
	protected void beforeWork() throws InterruptedException {
		// do nothing
	}
	
	@Override
	protected boolean willThereBeAnyMoreWork() {
		return true; //we do work forever or we are stopped by exceeding work iterations
	}
	
	@Override
	public void printHarvestCount() {
		System.out.println(String.format("%s killed %d boars", getClass().getSimpleName(), getFarmCount()));
	}
}
