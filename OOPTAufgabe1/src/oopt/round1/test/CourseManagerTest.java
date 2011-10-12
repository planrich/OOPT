package oopt.round1.test;

import junit.framework.Assert;
import oopt.round1.CourseManager;

import org.junit.Test;

public class CourseManagerTest {
	
	@Test
	public void testCourseCreation() {
		Assert.assertNotNull(CourseManager.createNewCourse("123", "Course 1"));
		Assert.assertNotNull(CourseManager.createNewCourse("234", "Course 2"));
	}
	
	@Test
	public void testStudentCreation() {
		Assert.assertNotNull(CourseManager.createNewStudent("123", "Simon Zuend"));
		Assert.assertNotNull(CourseManager.createNewStudent("234", "Klaus Nigsch"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailingStudentCreation() {
		CourseManager.createNewStudent(null, "Simon Zuend");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailingCourseCreation() {
		CourseManager.createNewCourse(null, "Course 1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionIfCourseAlreadyExists() {
		CourseManager.createNewCourse("123", "Course 1");
		CourseManager.createNewCourse("123", "Course 2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionIfStudentAlreadyExists() {
		CourseManager.createNewStudent("123", "Simon Zuend");
		CourseManager.createNewStudent("123", "Klaus Nigsch");
	}
	
	@Test
	public void testStudentCountInCourse() {
		CourseManager.createNewCourse("456", "Course 1");
		CourseManager.createNewStudent("456", "Simon Zuend");
		CourseManager.createNewStudent("567", "Klaus Nigsch");
		CourseManager.enrole("456", "456");
		CourseManager.enrole("456", "567");
		Assert.assertEquals(2, CourseManager.studentCountIn("456"));
	}
	
	@Test
	public void testStudentCountForNonExistingCourse() {
		Assert.assertEquals(0, CourseManager.studentCountIn("Does not exist"));
	}
}
