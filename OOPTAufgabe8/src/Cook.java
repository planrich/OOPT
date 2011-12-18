
public class Cook extends Worker {

	public Cook(long duration) {
		super(duration);
	}

	@Override
	protected void beforeWork() throws InterruptedException {
		synchronized (CoolingWareHouse.instance().removingLock) {
			while (!CoolingWareHouse.instance().removeWildBoar()) {
				System.out.println("The cook is waiting ...");
				CoolingWareHouse.instance().removingLock.wait();
			}
			System.out.println("Cook removed a wildboar.");
		}
	}

	@Override
	protected void afterWork() throws InterruptedException {
		
	}
}
