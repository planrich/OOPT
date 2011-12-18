
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
		System.out.println("Cook added 5 meals to the table.");
	}
}
