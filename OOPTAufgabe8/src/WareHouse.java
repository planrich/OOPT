import java.util.ArrayList;
import java.util.List;


public abstract class WareHouse {
	
	private int wareCount = 0;
	private int maxCount;
	private List<Worker> harvestWorker;
	
	public WareHouse(int maxCount) {
		this.maxCount = maxCount;
		harvestWorker = new ArrayList<Worker>();
	}
	
	/**
	 * add a harvesting worker.
	 * must be done by subclass to ensure only valid workers are added (hunter only to {@link CoolingWareHouse}, ...)
	 * @param w must not be null
	 */
	protected void addWorker(Worker w) { 
		harvestWorker.add(w);
	}
	
	/**
	 * Is there any worker that will eventually work again?
	 * 
	 * @return true iff any state of any worker is not terminated, false otherwise
	 */
	public boolean anyHarvestWorkerIsGoingToWork() {
		for (Worker w : harvestWorker) {
			if (!w.getState().equals(Thread.State.TERMINATED)) {
				return true;
			}
		}
		
		return false;
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
