
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
			
			// simulate the work time
			try { Thread.sleep(duration); }
			catch (InterruptedException ex) {
				return;
			}
			
			// do the real time
			try { doWork(); }
			catch (InterruptedException ex) {
				return;
			}
			
			if (workIterations != (-1)) {
				workIterations--;
			}
		}
	}
	
	/**
	 * Every worker must implement this method.
	 * If operations must be atomic, use synchronized blocks inside this method.
	 */
	protected abstract void doWork() throws InterruptedException;
}
