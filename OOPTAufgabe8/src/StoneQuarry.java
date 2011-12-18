
public class StoneQuarry extends WareHouse {

	private static final int MAX_COUNT = 20;
	
	private static StoneQuarry instance = null;
	
	private StoneQuarry(int maxCount) {
		super(maxCount);
	}
	
	public static StoneQuarry instance() {
		if (instance == null) {
			instance = new StoneQuarry(MAX_COUNT);
		}
		return instance;
	}
}
