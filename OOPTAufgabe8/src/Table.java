
public class Table extends WareHouse {

	private static final int MAX_COUNT = 15;
	
	private static Table instance = null;
	
	private Table(int maxCount) {
		super(maxCount);
	}
	
	public static Table instance() {
		if (instance == null) {
			instance = new Table(MAX_COUNT);
		}
		return instance;
	}
}
