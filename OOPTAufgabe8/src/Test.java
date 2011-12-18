
public class Test {
	public static void main(String[] args) {
		WildBoarHunter hunter = new WildBoarHunter(50, 10);
		hunter.start();
		
		Cook cook = new Cook(50);
		cook.start();
		
		try { Thread.sleep(9000); }
		catch (InterruptedException ex) {}
		
		System.out.println("Business is not going good, killing all workers ...");
		hunter.interrupt();
		cook.interrupt();
	}
}
