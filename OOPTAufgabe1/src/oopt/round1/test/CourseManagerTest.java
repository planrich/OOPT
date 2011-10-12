package oopt.round1.test;

import java.util.Date;

import junit.framework.Assert;
import oopt.round1.Course;
import oopt.round1.CourseManager;

import org.junit.Before;
import org.junit.Test;

public class CourseManagerTest {
	
	private CourseManager cm;
	
	@Before
	public void init() {
		cm = new CourseManager();
	}
	
	@Test
	public void testCourseCreation() {
		
		Assert.assertNotNull(cm.createNewCourse("123", "Course 1"));
		Assert.assertNotNull(cm.createNewCourse("234", "Course 2"));
	}
	
	@Test
	public void testStudentCreation() {
		Assert.assertNotNull(cm.createNewStudent("123", "Simon Zuend"));
		Assert.assertNotNull(cm.createNewStudent("234", "Klaus Nigsch"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailingStudentCreation() {
		cm.createNewStudent(null, "Simon Zuend");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailingCourseCreation() {
		cm.createNewCourse(null, "Course 1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionIfCourseAlreadyExists() {
		cm.createNewCourse("123", "Course 1");
		cm.createNewCourse("123", "Course 2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionIfStudentAlreadyExists() {
		cm.createNewStudent("123", "Simon Zuend");
		cm.createNewStudent("123", "Klaus Nigsch");
	}
	
	@Test
	public void testStudentCountInCourse() {
		cm.createNewCourse("456", "Course 1");
		cm.createNewStudent("456", "Simon Zuend");
		cm.createNewStudent("567", "Klaus Nigsch");
		cm.enrole("456", "456");
		cm.enrole("456", "567");
		Assert.assertEquals(2, cm.studentCountIn("456"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testStudentCountForNonExistingCourse() {
		Assert.assertEquals(0, cm.studentCountIn("Does not exist"));

	}
	
	@Test
	public void normalEnrolement() {
		cm.createNewStudent("1232", "Simon Zuend");
		Course c = cm.createNewCourse("abc", "LVA");
		c.setLateEnrol(new Date(System.currentTimeMillis() + (3 * 60 * 60 * 24) * 100));
		c.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100));
		c.setLateUnenrol(new Date(System.currentTimeMillis() + (4 * 60 * 60 * 24) * 100));
		
		Assert.assertTrue(cm.enrole("abc", "1232"));
	}
	
	@Test
	public void tooLateEnrolement() {
		cm.createNewStudent("12321", "Simon Zuend");
		Course c = cm.createNewCourse("abcd", "LVA");
		c.setLateEnrol(new Date(System.currentTimeMillis() - (3 * 60 * 60 * 24) * 100));
		c.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100));
		c.setLateUnenrol(new Date(System.currentTimeMillis() + (4 * 60 * 60 * 24) * 100));
		
		Assert.assertFalse(cm.enrole("abcd", "12321"));
	}
	
	@Test
	public void tooEarlyEnrolement() {
		cm.createNewStudent("12321", "Simon Zuend");
		Course c = cm.createNewCourse("abcd", "LVA");
		c.setLateEnrol(new Date(System.currentTimeMillis() + (5 * 60 * 60 * 24) * 100));
		c.setEarlyEnrol(new Date(System.currentTimeMillis() + (4 * 60 * 60 * 24) * 100));
		c.setLateUnenrol(new Date(System.currentTimeMillis() + (6 * 60 * 60 * 24) * 100));
		
		Assert.assertFalse(cm.enrole("abcd", "12321"));
	}
	
	@Test
	public void unenroleNormal() {
		cm.createNewStudent("12321", "Simon Zuend");
		Course c = cm.createNewCourse("abcd", "LVA");
		c.setLateEnrol(new Date(System.currentTimeMillis() + (3 * 60 * 60 * 24) * 100));
		c.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100));
		c.setLateUnenrol(new Date(System.currentTimeMillis() + (4 * 60 * 60 * 24) * 100));
		
		Assert.assertTrue(cm.enrole("abcd", "12321"));
		Assert.assertTrue(cm.unenrole("abcd", "12321"));
	}
	
	@Test
	public void tooLateNormal() {
		cm.createNewStudent("12321", "Simon Zuend");
		Course c = cm.createNewCourse("abcd", "LVA");
		c.setLateEnrol(new Date(System.currentTimeMillis() + (3 * 60 * 60 * 24) * 100));
		c.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100));
		c.setLateUnenrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100));
		
		Assert.assertTrue(cm.enrole("abcd", "12321"));
		Assert.assertFalse(cm.unenrole("abcd", "12321"));
	}
}
