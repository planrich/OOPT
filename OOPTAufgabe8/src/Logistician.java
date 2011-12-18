
public class Logistician extends Worker {

	public Logistician(long duration) {
		super(duration);
	}

	@Override
	protected void beforeWork() throws InterruptedException {
		synchronized (StoneQuarry.instance().removingLock) {
			while (!StoneQuarry.instance().removeWare(2)) {
				System.out.println("Log is wating for the StoneQuarry.");
				StoneQuarry.instance().removingLock.wait();
			}
		}
		System.out.println("Log removed 2 trees from the StoneQuarry.");
	}

	@Override
	protected void afterWork() throws InterruptedException {
		synchronized (CivicCenter.instance().addingLock) {
			while (!CivicCenter.instance().addWare(1)) {
				System.out.println("Log is waiting for the CivicCenter.");
				CivicCenter.instance().addingLock.wait();
			}
		}
		System.out.println("Log added an Ochsen Karrent to the CivicCenter.");
	}

}
