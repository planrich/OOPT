package oopt.round1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManager {

	private final List<Course> courses = new ArrayList<Course>();
	private final List<Student> students = new ArrayList<Student>();
	private final Map<Course, List<Student>> enrolments = new HashMap<Course, List<Student>>();
	
	/**
	 * Create a new {@link Course} with the specified data.
	 * {@link IllegalArgumentException} is thrown if the {@link Course} (with this lvaIdentifier) already exists
	 * @param lvaIdentifier
	 * @param name
	 * @return the created {@link Course}
	 */
	public Course createNewCourse(String lvaIdentifier, String name) {
		Course course = new Course(lvaIdentifier, name);
		if (courses.contains(course)) {
			throw new IllegalArgumentException("Course with this lvaIdentifier already exists.");
		}
		
		courses.add(course);
		return course;
	}
	
	/**
	 * Create a new {@link Student}
	 * {@link IllegalArgumentException} is thrown if another student with this matrikelNumber
	 * exists.
	 * @param matrikelNumber
	 * @param name
	 * @return
	 */
	public Student createNewStudent(String matrikelNumber, String name) {
		Student student = new Student(matrikelNumber, name);
		if (students.contains(student)) {
			throw new IllegalArgumentException("Student with this Matrikel Number already exists.");
		}
		
		students.add(student);
		return student;
	}
	
	//for now we return boolean maybe change that in the future?
	/**
	 * Enrole a {@link Student} to a {@link Course} 
	 * @param lvaIdentifier
	 * @param matrikelNumber
	 * @return true if the {@link Student} is successfully enroled, false otherwise
	 */
	public boolean enrole(String lvaIdentifier, String matrikelNumber) {

		Course course = getCourseFor(lvaIdentifier);
		
		Date now = new Date();
		
		if (now.before(course.getEarlyEnrol()) || now.after(course.getLateEnrol())) {
			return false;
		}
		
		List<Student> studentsInCourse = enrolments.get(course);
		if (studentsInCourse == null) {
			studentsInCourse = new ArrayList<Student>();
			enrolments.put(course, studentsInCourse);
		}
		
		Student student = getStudentFor(matrikelNumber);
		
		if (studentsInCourse.contains(student)) {
			return false;
		}
		
		studentsInCourse.add(student);
		
		return true;
	}
	
	/**
	 * Unenrole a {@link Student} from a course.
	 * @param lvaIdentifier
	 * @param matrikelNumber
	 * @return true if the unenrole deadline has not passed, false otherwise
	 */
	public boolean unenrole(String lvaIdentifier, String matrikelNumber) {

		Course course = getCourseFor(lvaIdentifier);
		
		Date now = new Date();
		
		if (now.after(course.getLateUnenrol())) {
			return false;
		}
		
		List<Student> studentsInCourse = enrolments.get(course);
		if (studentsInCourse != null) {
			return studentsInCourse.remove(getStudentFor(matrikelNumber));
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param lvaIdentifier
	 * @return count of all {@link Student}s that have been created
	 */
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
