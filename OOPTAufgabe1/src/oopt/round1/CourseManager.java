package oopt.round1;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {

	private static final List<Course> courses = new ArrayList<Course>();
	
	public static Course createNewCourse(String lvaIdentifier, String name) {
		Course course = new Course(lvaIdentifier, name);
		if (courses.contains(course)) {
			throw new IllegalArgumentException("Course with this lvaIdentifier already exists.");
		}
		
		courses.add(course);
		return course;
	}
}
