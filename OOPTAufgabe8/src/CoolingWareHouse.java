
public class CoolingWareHouse extends WareHouse {

	private static CoolingWareHouse instance = null;
	private int wildBoarCount = 0;
	
	private CoolingWareHouse() {}
	
	public static CoolingWareHouse instance() {
		if (instance == null) {
			instance = new CoolingWareHouse();
		}
		return instance;
	}
	
	public synchronized void addWildBoar() {
		wildBoarCount += 1;
	}
	
	public synchronized void removeWildBoar() {
		wildBoarCount -= 1;
	}
	
	public synchronized int getWildBoarCount() {
		return wildBoarCount;
	}
}
