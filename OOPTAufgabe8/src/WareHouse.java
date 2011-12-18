
public abstract class WareHouse {
	
	public Object addingLock = new Object();
	public Object removingLock = new Object();
	
	private int wareCount = 0;
	private int maxCount;
	
	public WareHouse(int maxCount) {
		this.maxCount = maxCount;
	}
	
	public synchronized boolean addWildBoar() {
		synchronized (removingLock) {
			if (wareCount == maxCount) {
				return false;
			}
			wareCount += 1;
			removingLock.notifyAll();
			return true;
		}
	}
	
	public synchronized boolean removeWildBoar() {
		synchronized (addingLock) {
			if (wareCount == 0) {
				return false;
			}
			wareCount -= 1;
			addingLock.notifyAll();
			return true;
		}
	}
	
	public synchronized int getWareCount() {
		return wareCount;
	}
}
