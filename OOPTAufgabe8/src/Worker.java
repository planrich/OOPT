
/**
 * This is a template class for a worker.
 * @author Simon
 */
public abstract class Worker extends Thread {
	
	protected long duration;
	protected int workIterations;
	
	/**
	 * How many items (Boar,Food,...) has been produced or farmed
	 */
	protected int farmCount;
	
	/**
	 * You can specify how often this worker should do his work.
	 * -1 as parameter means infinitly
	 */
	public Worker(int workIterations, long duration) {
		this.workIterations = workIterations;
		this.duration = duration;
		this.farmCount = 0;
	}
	
	public Worker(long duration) {
		this(-1, duration);
	}
	
	/**
	 * dependant on instance, cook -> made meals
	 * woodcutter -> amount of trees
	 * hunter -> amount of boars killed
	 * logistician -> amount of trees delivered
	 * @return the farmcount
	 */
	public int getFarmCount() {
		return farmCount;
	}
	
	/**
	 * This is a endless loop template for the workers.
	 * Checks for interrupts and simulates the work by sleeping
	 * DURATION millis.
	 */
	public void run() {
		while (workIterations > 0 || workIterations == (-1)) {
			// Check for interruptions and end if one occurred
			if (Thread.interrupted()) {
				return;
			}
			
			try { 
				beforeWork();
				Thread.sleep(duration);
				afterWork();
			} catch (InterruptedException ex) {
				return;
			}
			
			synchronized (this) {
				if (workIterations != (-1)) {
					workIterations--;
				} else if (!willThereBeAnyMoreWork()) { //one day there is xmas -> nobody wants to work anymore
					System.out.println(String.format("%s: there is no more work, i'm out!", this.getClass().getSimpleName()));
					workIterations = 0;
				}
			}
		}
	}
	
	/**
	 * Does a worker has more work? Yes if there are any resources left or the dependant workers do still work
	 * @return true iff there is any resource left (cook-boar,...) or one dependant worker is still working, false otherwise
	 */
	protected abstract boolean willThereBeAnyMoreWork();
	
	/**
	 * Do stuff like getting the ingredients in this method.
	 */
	protected abstract void beforeWork() throws InterruptedException;
	
	/**
	 * If operations must be atomic, use synchronized blocks inside this method.
	 */
	protected abstract void afterWork() throws InterruptedException;

	/**
	 * utility method
	 */
	public abstract void printHarvestCount();
}
