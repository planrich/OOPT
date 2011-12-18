
public class Cook extends Worker {

	private static final int MEALS_PER_BOAR = 5;
	
	public Cook(long duration) {
		super(duration);
	}

	@Override
	protected void beforeWork() throws InterruptedException {
		synchronized (CoolingWareHouse.instance().removingLock) {
			while (!CoolingWareHouse.instance().removeWare(1)) {
				System.out.println("The cook is waiting ...");
				CoolingWareHouse.instance().removingLock.wait();
			}
			System.out.println("Cook removed a wildboar.");
		}
	}

	@Override
	protected void afterWork() throws InterruptedException {
		synchronized (Table.instance().addingLock) {
			while (!Table.instance().addWare(MEALS_PER_BOAR)) {
				System.out.println("The cook is wating for the table ...");
				Table.instance().addingLock.wait();
			}
			System.out.println("Cook added 5 meals to the table.");
		}
	}
}
