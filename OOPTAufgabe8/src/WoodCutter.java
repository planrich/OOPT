
public class WoodCutter extends Worker {

	public WoodCutter(long duration) {
		super(duration);
	}

	@Override
	protected void beforeWork() throws InterruptedException {
		synchronized (Table.instance().removingLock) {
			while (!Table.instance().removeWare(1)) {
				System.out.println("WoodCutter is waiting for the table.");
				Table.instance().removingLock.wait();
			}
		}
		System.out.println("WoodCutter ate a meal.");
	}

	@Override
	protected void afterWork() throws InterruptedException {
		synchronized (StoneQuarry.instance().addingLock) {
			while (!StoneQuarry.instance().addWare(1)) {
				System.out.println("WoodCutter is waiting for the StoneQuarry.");
				StoneQuarry.instance().addingLock.wait();
			}
		}
		System.out.println("WoodCutter added a new tree.");
	}
}
