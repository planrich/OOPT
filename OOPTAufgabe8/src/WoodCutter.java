
public class WoodCutter extends Worker {

	public WoodCutter(long duration) {
		super(duration);
	}

	@Override
	protected void beforeWork() throws InterruptedException {
		Table.instance().removeWare(1);
		System.out.println("WoodCutter ate a meal.");
	}

	@Override
	protected void afterWork() throws InterruptedException {
		StoneQuarry.instance().addWare(1);
		++farmCount;
		System.out.println("WoodCutter added a new tree.");
	}
	
	@Override
	protected boolean willThereBeAnyMoreWork() {
		Table t = Table.instance();
		return t.anyHarvestWorkerIsGoingToWork() || t.getWareCount() > 0; //NO FOOD -> NO WORK
		
	}
	
	@Override
	public void printHarvestCount() {
		System.out.println(String.format("%s cut down %d trees", getClass().getSimpleName(), getFarmCount()));
	}
}
