
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
		System.out.println("WoodCutter added a new tree.");
	}
}
