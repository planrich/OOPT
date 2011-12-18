
public class Cook extends Worker {

	public Cook(long duration) {
		super(duration);
	}

	@Override
	protected void beforeWork() throws InterruptedException {
		synchronized (CoolingWareHouse.instance().removingLock) {
			while (!CoolingWareHouse.instance().removeWare(1)) {
				System.out.println("Cook is wating for a boar.");
				CoolingWareHouse.instance().removingLock.wait();
			}
			System.out.println("Cook removed a wildboar.");
		}
	}

	@Override
	protected void afterWork() throws InterruptedException {
		synchronized (Table.instance().addingLock) {
			while (!Table.instance().addWare(5)) {
				System.out.println("Cook is wating for the table.");
				Table.instance().addingLock.wait();
			}
			System.out.println("Cook added 5 meals to the table.");
		}
	}
}
