package oopt.round1.test;

import oopt.round1.CourseManager;

import org.junit.Test;

public class CourseManagerTest {
	
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
}
