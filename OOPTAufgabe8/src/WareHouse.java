
public abstract class WareHouse {
	
	public Object addingLock = new Object();
	public Object removingLock = new Object();
	
	private int wareCount = 0;
	private int maxCount;
	
	public WareHouse(int maxCount) {
		this.maxCount = maxCount;
	}
	
	public synchronized boolean addWare(int count) {
		synchronized (removingLock) {
			if (wareCount + count > maxCount) {
				return false;
			}
			wareCount += count;
			removingLock.notifyAll();
			return true;
		}
	}
	
	public synchronized boolean removeWare(int count) {
		synchronized (addingLock) {
			if (wareCount - count < 0) {
				return false;
			}
			wareCount -= count;
			addingLock.notifyAll();
			return true;
		}
	}
	
	public synchronized int getWareCount() {
		return wareCount;
	}
}
