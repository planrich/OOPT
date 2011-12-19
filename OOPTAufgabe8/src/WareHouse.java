import java.util.ArrayList;
import java.util.List;


public abstract class WareHouse {
	
	private int wareCount = 0;
	private int maxCount;
	private List<Worker> harvestWorker;
	
	/**
	 * @param maxCount has to be >0
	 */
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
	 * @return true if state of any worker is not terminated, false otherwise
	 */
	public boolean anyHarvestWorkerIsGoingToWork() {
		for (Worker w : harvestWorker) {
			if (!w.getState().equals(Thread.State.TERMINATED)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * @param count has to be >0
	 * @throws InterruptedException
	 */
	public synchronized void addWare(int count) throws InterruptedException {
		while (wareCount + count > maxCount) {
			wait();
		}
		wareCount += count;
		notify();
	}
	
	/**
	 * @param count has to be >0
	 * @throws InterruptedException
	 */
	public synchronized void removeWare(int count) throws InterruptedException {
		while (wareCount - count < 0) {
			wait();
		}
		wareCount -= count;
		notify();
	}
	
	/**
	 * @return wareCount of the WareHouse
	 */
	public synchronized int getWareCount() {
		return wareCount;
	}
	
	/**
	 * @param maxCount has to be >0
	 */
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
}
