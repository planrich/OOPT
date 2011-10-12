package oopt.round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManager {

	private final List<Course> courses = new ArrayList<Course>();
	private final List<Student> students = new ArrayList<Student>();
	private final Map<Course, List<Student>> enrolments = new HashMap<Course, List<Student>>();
	
	public Course createNewCourse(String lvaIdentifier, String name) {
		Course course = new Course(lvaIdentifier, name);
		if (courses.contains(course)) {
			throw new IllegalArgumentException("Course with this lvaIdentifier already exists.");
		}
		
		courses.add(course);
		return course;
	}
	
	public Student createNewStudent(String matrikelNumber, String name) {
		Student student = new Student(matrikelNumber, name);
		if (students.contains(student)) {
			throw new IllegalArgumentException("Student with this Matrikel Number already exists.");
		}
		
		students.add(student);
		return student;
	}
	
	public void enrole(String lvaIdentifier, String matrikelNumber) {
		Course course = getCourseFor(lvaIdentifier);
		List<Student> studentsInCourse = enrolments.get(course);
		if (studentsInCourse == null) {
			studentsInCourse = new ArrayList<Student>();
			enrolments.put(course, studentsInCourse);
		}
		Student student = getStudentFor(matrikelNumber);
		studentsInCourse.add(student);
	}
	
	public void unenrole(String lvaIdentifier, String matrikelNumber) {
		Course course = getCourseFor(lvaIdentifier);
		List<Student> studentsInCourse = enrolments.get(course);
		if (studentsInCourse != null) {
			studentsInCourse.remove(getStudentFor(matrikelNumber));
		}
	}
	
	public int studentCountIn(String lvaIdentifier) {
		Course course = getCourseFor(lvaIdentifier);
		List<Student> studentsInCourse = enrolments.get(course);
		if (studentsInCourse == null) {
			return 0;
		}
		return studentsInCourse.size();
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public List<Student> getStudents() {
		return students;
	}
	
	private Course getCourseFor(String lvaIdentifier) {
		for (Course course : courses) {
			if (course.getLvaIdentifier().equals(lvaIdentifier)) {
				return course;
			}
		}
		throw new IllegalArgumentException("Course '" + lvaIdentifier + "' does not exist");
	}
	
	private Student getStudentFor(String matrikelNumber) {
		for (Student student : students) {
			if (student.getMatrikelNumber().equals(matrikelNumber)) {
				return student;
			}
		}
		throw new IllegalArgumentException("Student '" + matrikelNumber + "' does not exist");
	}
}
