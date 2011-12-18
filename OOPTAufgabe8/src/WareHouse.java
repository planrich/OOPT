
public abstract class WareHouse {
	
	private int wareCount = 0;
	private int maxCount;
	
	public WareHouse(int maxCount) {
		this.maxCount = maxCount;
	}
	
	public synchronized void addWare(int count) throws InterruptedException {
		while (wareCount + count > maxCount) {
			wait();
		}
		wareCount += count;
		notify();
	}
	
	public synchronized void removeWare(int count) throws InterruptedException {
		while (wareCount - count < 0) {
			wait();
		}
		wareCount -= count;
		notify();
	}
	
	public synchronized int getWareCount() {
		return wareCount;
	}
	
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
}
