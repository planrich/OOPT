
public class CivicCenter extends WareHouse {
	
	private static final int MAX_COUNT = 2000;
	
	private static CivicCenter instance = null;
	
	private CivicCenter(int maxCount) {
		super(maxCount);
	}
	
	public static CivicCenter instance() {
		if (instance == null) {
			instance = new CivicCenter(MAX_COUNT);
		}
		return instance;
	}
}
