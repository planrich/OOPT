
/**
 * This is a template class for a worker.
 * @author Simon
 */
public abstract class Worker extends Thread {
	
	protected long duration;
	protected int workIterations;
	
	/**
	 * You can specify how often this worker should do his work.
	 * -1 as parameter means infinitly
	 */
	public Worker(int workIterations, long duration) {
		this.workIterations = workIterations;
		this.duration = duration;
	}
	
	public Worker(long duration) {
		this(-1, duration);
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
				}
			}
		}
	}
	
	/**
	 * Do stuff like getting the ingredients in this method.
	 */
	protected abstract void beforeWork() throws InterruptedException;
	
	/**
	 * If operations must be atomic, use synchronized blocks inside this method.
	 */
	protected abstract void afterWork() throws InterruptedException;
}
