import junit.framework.Assert;

import org.junit.Test;


public class TestInorderTree extends TestSortedTree {

	@Override
	protected SortedTree<Integer> getTreeImpl() {
		return new InorderTree<Integer>();
	}

	@Test
	public void testIterator() {
		TreeIter<Integer> iter = tree.iterator();
		Assert.assertNotNull(iter);
		
		Assert.assertNull(iter.previous());
		Assert.assertEquals(Integer.valueOf(2), iter.next());
		Assert.assertEquals(Integer.valueOf(5), iter.next());
		Assert.assertEquals(Integer.valueOf(7), iter.next());
		
		Assert.assertEquals(Integer.valueOf(5), iter.previous());
		Assert.assertEquals(Integer.valueOf(2), iter.previous());
		
		Assert.assertEquals(Integer.valueOf(5), iter.next());
		Assert.assertEquals(Integer.valueOf(7), iter.next());
		Assert.assertEquals(Integer.valueOf(10), iter.next());
		Assert.assertEquals(Integer.valueOf(12), iter.next());
		Assert.assertEquals(Integer.valueOf(15), iter.next());
		Assert.assertEquals(Integer.valueOf(20), iter.next());
		
		Assert.assertNull(iter.next());
	}
}
