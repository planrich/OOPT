import junit.framework.Assert;

import org.junit.Test;

public class UnitTestList {

	@Test
	public void testEmptyList() {
		List<Integer> list = new List<Integer>();
		List.Iterator<Integer> iter = list.iterator();
		
		Assert.assertNull(iter.next());
		Assert.assertNull(iter.previous());
		Assert.assertFalse(iter.hasNext());
		Assert.assertFalse(iter.hasPrevious());
	}
	
	@Test
	public void testFilledList() {
		List<Integer> list = new List<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		List.Iterator<Integer> iter = list.iterator();
		
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(10), iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(20), iter.next());
		Assert.assertTrue(iter.hasPrevious());
		Assert.assertEquals(Integer.valueOf(10), iter.previous());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(20), iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(30), iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals(Integer.valueOf(40), iter.next());
		
		Assert.assertFalse(iter.hasNext());
	}
}
