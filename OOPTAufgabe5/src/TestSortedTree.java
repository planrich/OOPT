import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


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
	
	@Test
	public void testContains() {
		Assert.assertNotNull(tree.contains(10));
		Assert.assertNotNull(tree.contains(2));
		Assert.assertNotNull(tree.contains(15));
		Assert.assertNull(tree.contains(8));
		Assert.assertNull(tree.contains(30));
	}
	
	protected abstract SortedTree<Integer> getTreeImpl();
}
