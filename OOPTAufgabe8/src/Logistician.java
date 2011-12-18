
public class Logistician extends Worker {

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
		System.out.println("Log added an Ochsen Karrent to the CivicCenter.");
	}
}
