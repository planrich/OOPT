package oopt.round2.test;

import java.util.Date;

import junit.framework.Assert;

import oopt.round2.Course;
import oopt.round2.CourseManager;

import org.junit.Before;
import org.junit.Test;


public class CourseManagerTest {
	
	private CourseManager courseManager;
	
	@Before
	public void init() {
		courseManager = new CourseManager();
	}
	
	@Test
	public void testCourseCreation() {
		
		Assert.assertNotNull(courseManager.createNewCourse("123", "Course 1"));
		Assert.assertNotNull(courseManager.createNewCourse("234", "Course 2"));
	}
	
	@Test
	public void testStudentCreation() {
		Assert.assertNotNull(courseManager.createNewStudent("123", "Simon Zuend"));
		Assert.assertNotNull(courseManager.createNewStudent("234", "Klaus Nigsch"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailingStudentCreation() {
		courseManager.createNewStudent(null, "Simon Zuend");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailingCourseCreation() {
		courseManager.createNewCourse(null, "Course 1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionIfCourseAlreadyExists() {
		courseManager.createNewCourse("123", "Course 1");
		courseManager.createNewCourse("123", "Course 2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionIfStudentAlreadyExists() {
		courseManager.createNewStudent("123", "Simon Zuend");
		courseManager.createNewStudent("123", "Klaus Nigsch");
	}
	
	@Test
	public void testStudentCountInCourse() {
		courseManager.createNewCourse("456", "Course 1");
		courseManager.createNewStudent("456", "Simon Zuend");
		courseManager.createNewStudent("567", "Klaus Nigsch");
		courseManager.enrole("456", "456");
		courseManager.enrole("456", "567");
		Assert.assertEquals(2, courseManager.studentCountIn("456"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testStudentCountForNonExistingCourse() {
		Assert.assertEquals(0, courseManager.studentCountIn("Does not exist"));

	}
	
	@Test
	public void normalEnrolement() {
		courseManager.createNewStudent("1232", "Simon Zuend");
		Course c = courseManager.createNewCourse("abc", "LVA");
		c.setLateEnrol(new Date(System.currentTimeMillis() + (3 * 60 * 60 * 24) * 100));
		c.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100));
		c.setLateUnenrol(new Date(System.currentTimeMillis() + (4 * 60 * 60 * 24) * 100));
		
		Assert.assertTrue(courseManager.enrole("abc", "1232"));
	}
	
	@Test
	public void tooLateEnrolement() {
		courseManager.createNewStudent("12321", "Simon Zuend");
		Course c = courseManager.createNewCourse("abcd", "LVA");
		c.setLateEnrol(new Date(System.currentTimeMillis() - (3 * 60 * 60 * 24) * 100));
		c.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100));
		c.setLateUnenrol(new Date(System.currentTimeMillis() + (4 * 60 * 60 * 24) * 100));
		
		Assert.assertFalse(courseManager.enrole("abcd", "12321"));
	}
	
	@Test
	public void tooEarlyEnrolement() {
		courseManager.createNewStudent("12321", "Simon Zuend");
		Course c = courseManager.createNewCourse("abcd", "LVA");
		c.setLateEnrol(new Date(System.currentTimeMillis() + (5 * 60 * 60 * 24) * 100));
		c.setEarlyEnrol(new Date(System.currentTimeMillis() + (4 * 60 * 60 * 24) * 100));
		c.setLateUnenrol(new Date(System.currentTimeMillis() + (6 * 60 * 60 * 24) * 100));
		
		Assert.assertFalse(courseManager.enrole("abcd", "12321"));
	}
	
	@Test
	public void unenroleNormal() {
		courseManager.createNewStudent("12321", "Simon Zuend");
		Course c = courseManager.createNewCourse("abcd", "LVA");
		c.setLateEnrol(new Date(System.currentTimeMillis() + (3 * 60 * 60 * 24) * 100));
		c.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100));
		c.setLateUnenrol(new Date(System.currentTimeMillis() + (4 * 60 * 60 * 24) * 100));
		
		Assert.assertTrue(courseManager.enrole("abcd", "12321"));
		Assert.assertTrue(courseManager.unenrole("abcd", "12321"));
	}
	
	@Test
	public void tooLateUnenrolement() {
		courseManager.createNewStudent("12321", "Simon Zuend");
		Course c = courseManager.createNewCourse("abcd", "LVA");
		c.setLateEnrol(new Date(System.currentTimeMillis() + (3 * 60 * 60 * 24) * 100));
		c.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100));
		c.setLateUnenrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100));
		
		Assert.assertTrue(courseManager.enrole("abcd", "12321"));
		Assert.assertFalse(courseManager.unenrole("abcd", "12321"));
	}
}
