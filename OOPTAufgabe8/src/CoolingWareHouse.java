
public class CoolingWareHouse extends WareHouse {
	
	public Object addingLock = new Object();
	public Object removingLock = new Object();
	
	private static final int MAX_COUNT = 10;
	private static CoolingWareHouse instance = null;
	private int wildBoarCount = 0;
	
	private CoolingWareHouse() {}
	
	public static CoolingWareHouse instance() {
		if (instance == null) {
			instance = new CoolingWareHouse();
		}
		return instance;
	}
	
	public synchronized boolean addWildBoar() {
		synchronized (removingLock) {
			if (wildBoarCount == MAX_COUNT) {
				return false;
			}
			wildBoarCount += 1;
			removingLock.notifyAll();
			return true;
		}
	}
	
	public synchronized boolean removeWildBoar() {
		synchronized (addingLock) {
			if (wildBoarCount == 0) {
				return false;
			}
			wildBoarCount -= 1;
			addingLock.notifyAll();
			return true;
		}
	}
	
	public synchronized int getWildBoarCount() {
		return wildBoarCount;
	}
}
