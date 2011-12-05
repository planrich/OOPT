import junit.framework.Assert;

import org.junit.Test;

public class UnitTestList {

	@Test
	public void testEmptyList() {
		List list = new List();
		List.Iterator iter = list.iterator();
		
		Assert.assertNull(iter.next());
		Assert.assertNull(iter.previous());
		Assert.assertFalse(iter.hasNext());
		Assert.assertFalse(iter.hasPrevious());
	}
	
	@Test
	public void testFilledList() {
		List list = new List();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		List.Iterator iter = list.iterator();
		
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
	
	@Test
	public void testRemoveEmptyList() {
		List list = new List();
		list.remove("dd");
	}
	
	@Test
	public void testRemoveLastEntry() {
		List list = new List();
		list.add("a");
		list.remove("a");
		
		List.Iterator iter = list.iterator();
		Assert.assertFalse(iter.hasNext());
	}
	
	@Test
	public void testRemoveElement() {
		List list = new List();
		list.add("a");
		list.add("b");
		list.add("c");
		list.remove("b");
		
		List.Iterator iter = list.iterator();
		Assert.assertEquals("a", iter.next());
		Assert.assertEquals("c", iter.next());
		Assert.assertFalse(iter.hasNext());
		
		list.remove("c");
		iter = list.iterator();
		Assert.assertEquals("a", iter.next());
		Assert.assertFalse(iter.hasNext());
	}
}
