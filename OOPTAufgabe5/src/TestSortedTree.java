import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public abstract class TestSortedTree {

	protected static SortedTree<Integer> t1;
	
	@Before
	public void setup() {
		t1 = getTreeImpl();
		t1.add(10);
		t1.add(5);
		t1.add(7);
		t1.add(2);
		t1.add(15);
		t1.add(12);
		t1.add(20);
	}
	
	@Test
	public void testContains() {
		Assert.assertNotNull(t1.contains(10));
		Assert.assertNotNull(t1.contains(2));
		Assert.assertNotNull(t1.contains(15));
		Assert.assertNull(t1.contains(8));
		Assert.assertNull(t1.contains(30));
	}
	
	protected abstract SortedTree<Integer> getTreeImpl();
}
