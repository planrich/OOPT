
public class CoolingWareHouse extends WareHouse {
	
	private static final int MAX_COUNT = 10;

	private static CoolingWareHouse instance = null;
	
	private CoolingWareHouse(int maxCount) {
		super(maxCount);
	}
	
	public static CoolingWareHouse instance() {
		if (instance == null) {
			instance = new CoolingWareHouse(MAX_COUNT);
		}
		return instance;
	}
	
	/**
	 * Add a {@link WildBoarHunter}
	 * @param hunter must not be null
	 */
	public void add(WildBoarHunter hunter) {
		this.addWorker(hunter);
	}
}
