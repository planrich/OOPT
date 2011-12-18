
public class Logistician extends Worker {

	/**
	 * create a new tree logistician... what a special job
	 * @param duration must be > 0
	 */
	public Logistician(long duration) {
		super(duration);
	}

	@Override
	protected void beforeWork() throws InterruptedException {
		StoneQuarry.instance().removeWare(2);
		System.out.println("Log removed 2 trees from the StoneQuarry.");
	}

	@Override
	protected void afterWork() throws InterruptedException {
		CivicCenter.instance().addWare(1);
		farmCount += 2;
		System.out.println("Log added an Ochsen Karrent to the CivicCenter.");
	}
	
	@Override
	protected boolean willThereBeAnyMoreWork() {
		StoneQuarry sq = StoneQuarry.instance();
		return sq.anyHarvestWorkerIsGoingToWork() || sq.getWareCount() > 1; //NOTE if there is only 1 tree a logistician does nothing
	}
	
	@Override
	public void printHarvestCount() {
		System.out.println(String.format("%s delivered %d trees", getClass().getSimpleName(), getFarmCount()));
	}
}
