import org.junit.Before;


public abstract class TestSortedTree {

	protected static SortedTree<Integer> tree;
	
	@Before
	public void setup() {
		tree = getTreeImpl();
		tree.add(10);
		tree.add(5);
		tree.add(7);
		tree.add(2);
		tree.add(15);
		tree.add(12);
		tree.add(20);
	}
	
	protected abstract SortedTree<Integer> getTreeImpl();
}
