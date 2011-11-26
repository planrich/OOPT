import junit.framework.Assert;

import org.junit.Test;


public class TestPreorderTree extends TestSortedTree {

	@Override
	protected SortedTree<Integer> getTreeImpl() {
		return new PreorderTree<Integer>();
	}

	@Test
	public void testIterator() {
		TreeIter<Integer> iter = tree.iterator();
		Assert.assertNotNull(iter);
		
		Assert.assertNull(iter.previous());
		Assert.assertEquals(Integer.valueOf(10), iter.next());
		Assert.assertEquals(Integer.valueOf(5), iter.next());
		Assert.assertEquals(Integer.valueOf(2), iter.next());
		
		Assert.assertEquals(Integer.valueOf(5), iter.previous());
		Assert.assertEquals(Integer.valueOf(10), iter.previous());
		
		Assert.assertEquals(Integer.valueOf(5), iter.next());
		Assert.assertEquals(Integer.valueOf(2), iter.next());
		Assert.assertEquals(Integer.valueOf(7), iter.next());
		Assert.assertEquals(Integer.valueOf(15), iter.next());
		Assert.assertEquals(Integer.valueOf(12), iter.next());
		Assert.assertEquals(Integer.valueOf(20), iter.next());
		
		Assert.assertNull(iter.next());
	}
	
	@Test
	public void testContains() {
		TreeIter<Integer> iter = tree.contains(10);
		Assert.assertNotNull(iter);
		Assert.assertEquals(Integer.valueOf(10), iter.next());
		
		iter = tree.contains(2);
		Assert.assertNotNull(iter);
		Assert.assertEquals(Integer.valueOf(2), iter.next());
		
		iter = tree.contains(15);
		Assert.assertNotNull(iter);
		Assert.assertEquals(Integer.valueOf(15), iter.next());
		
		Assert.assertNull(tree.contains(8));
		Assert.assertNull(tree.contains(30));
	}
}
