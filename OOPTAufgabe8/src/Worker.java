
/**
 * This is a template class for a worker.
 * @author Simon
 */
public abstract class Worker extends Thread {
	
	/**
	 * How long does it take a worker to do its job?
	 * "Override" (shadow) it in the subclasses.
	 */
	protected static long DURATION = 200;
	
	/**
	 * This is a endless loop template for the workers.
	 * Checks for interrupts and simulates the work by sleeping
	 * DURATION millis.
	 */
	public void run() {
		while (true) {
			// Check for interruptions and end if one occurred
			if (Thread.interrupted()) {
				return;
			}
			
			// simulate the work time
			try { Thread.sleep(DURATION); }
			catch (InterruptedException ex) {
				return;
			}
			
			// do the real time
			doWork();
		}
	}
	
	/**
	 * Every worker must implement this method.
	 * If operations must be atomic, use synchronized blocks inside this method.
	 */
	protected abstract void doWork();
}
