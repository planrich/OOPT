
public class WildBoarHunter extends Worker {
	
	protected static long DURATION = 200;

	@Override
	protected void doWork() {
		CoolingWareHouse.instance().addWildBoar();
	}
}
