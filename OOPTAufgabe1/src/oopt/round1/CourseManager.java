package oopt.round1;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {

	private static final List<Course> courses = new ArrayList<Course>();
	private static final List<Student> students = new ArrayList<Student>();
	
	public static Course createNewCourse(String lvaIdentifier, String name) {
		Course course = new Course(lvaIdentifier, name);
		if (courses.contains(course)) {
			throw new IllegalArgumentException("Course with this lvaIdentifier already exists.");
		}
		
		courses.add(course);
		return course;
	}
	
	public static Student createNewStudent(String matrikelNumber, String name) {
		Student student = new Student(matrikelNumber, name);
		if (students.contains(student)) {
			throw new IllegalArgumentException("Student with this Matrikel Number already exists.");
		}
		
		students.add(student);
		return student;
	}
}
