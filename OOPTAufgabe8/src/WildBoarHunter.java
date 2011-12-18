
public class WildBoarHunter extends Worker {
	
	public WildBoarHunter(int workIterations, long duration) {
		super(workIterations, duration);
	}

	@Override
	protected void doWork() {
		CoolingWareHouse.instance().addWildBoar();
	}
}
