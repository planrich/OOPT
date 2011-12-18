
public class Cook extends Worker {

	public Cook(long duration) {
		super(duration);
	}

	@Override
	protected void beforeWork() throws InterruptedException {
		CoolingWareHouse.instance().removeWare(1);
		System.out.println("Cook got a boar.");
	}

	@Override
	protected void afterWork() throws InterruptedException {
		Table.instance().addWare(5);
		farmCount += 5;
		System.out.println("Cook added 5 meals to the table.");
	}
	
	@Override
	protected boolean willThereBeAnyMoreWork() {
		CoolingWareHouse c = CoolingWareHouse.instance();
		return c.anyHarvestWorkerIsGoingToWork() || c.getWareCount() > 0;
	}
	
	@Override
	public void printHarvestCount() {
		System.out.println(String.format("%s made %d meals", getClass().getSimpleName(), getFarmCount()));
	}
}
