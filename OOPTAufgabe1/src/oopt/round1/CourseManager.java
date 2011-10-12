package oopt.round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManager {

	private static final List<Course> courses = new ArrayList<Course>();
	private static final List<Student> students = new ArrayList<Student>();
	private static final Map<Course, List<Student>> enrolments = new HashMap<Course, List<Student>>();
	
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
	
	public static void enrole(String lvaIdentifier, String matrikelNumber) {
		Course course = getCourseFor(lvaIdentifier);
		List<Student> studentsInCourse = enrolments.get(course);
		if (studentsInCourse == null) {
			studentsInCourse = new ArrayList<Student>();
			enrolments.put(course, studentsInCourse);
		}
		Student student = getStudentFor(matrikelNumber);
		studentsInCourse.add(student);
	}
	
	public static void unenrole(String lvaIdentifier, String matrikelNumber) {
		Course course = getCourseFor(lvaIdentifier);
		List<Student> studentsInCourse = enrolments.get(course);
		if (studentsInCourse != null) {
			studentsInCourse.remove(getStudentFor(matrikelNumber));
		}
	}
	
	public static int studentCountIn(String lvaIdentifier) {
		Course course = getCourseFor(lvaIdentifier);
		List<Student> studentsInCourse = enrolments.get(course);
		return studentsInCourse.size();
	}
	
	private static Course getCourseFor(String lvaIdentifier) {
		for (Course course : courses) {
			if (course.getLvaIdentifier().equals(lvaIdentifier)) {
				return course;
			}
		}
		throw new IllegalArgumentException("Course '" + lvaIdentifier + "' does not exist");
	}
	
	private static Student getStudentFor(String matrikelNumber) {
		for (Student student : students) {
			if (student.getMatrikelNumber().equals(matrikelNumber)) {
				return student;
			}
		}
		throw new IllegalArgumentException("Student '" + matrikelNumber + "' does not exist");
	}
}
