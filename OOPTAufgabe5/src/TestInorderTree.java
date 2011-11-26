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
		Assert.assertFalse(iter.hasPrevious());
		
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(2), iter.next());
		
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(5), iter.next());
		
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(7), iter.next());
		
		Assert.assertTrue(iter.hasPrevious());
		Assert.assertEquals(Integer.valueOf(5), iter.previous());
		Assert.assertTrue(iter.hasPrevious());
		Assert.assertEquals(Integer.valueOf(2), iter.previous());
		
		Assert.assertEquals(Integer.valueOf(5), iter.next());
		Assert.assertEquals(Integer.valueOf(7), iter.next());
		Assert.assertEquals(Integer.valueOf(10), iter.next());
		Assert.assertEquals(Integer.valueOf(12), iter.next());
		Assert.assertEquals(Integer.valueOf(15), iter.next());
		Assert.assertEquals(Integer.valueOf(20), iter.next());
		
		Assert.assertNull(iter.next());
		Assert.assertFalse(iter.hasNext());
	}
	
	@Test
	public void testIteratorDown() {
		TreeIter<Integer> iter = tree.iterator();
		Assert.assertNotNull(iter);
		
		Assert.assertNull(iter.previous());
		Assert.assertFalse(iter.hasPrevious());
		
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(2), iter.next());
		
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(5), iter.next());
		
		TreeIter<Integer> downIter = iter.down();
		
		Assert.assertNotNull(downIter);
		
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(2), downIter.next());
		
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(5), downIter.next());
		
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(7), downIter.next());
		
		Assert.assertFalse(downIter.hasNext());
	}
	
	@Test
	public void testContains() {
		TreeIter<Integer> iter = tree.contains(10);
		Assert.assertNotNull(iter);
		Assert.assertEquals(Integer.valueOf(2), iter.next());
		
		iter = tree.contains(2);
		Assert.assertNotNull(iter);
		Assert.assertEquals(Integer.valueOf(2), iter.next());
		
		iter = tree.contains(15);
		Assert.assertNotNull(iter);
		Assert.assertEquals(Integer.valueOf(12), iter.next());
		
		Assert.assertNull(tree.contains(8));
		Assert.assertNull(tree.contains(30));
	}
}
