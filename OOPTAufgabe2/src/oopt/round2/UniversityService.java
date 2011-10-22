package oopt.round2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UniversityService {

	private final List<Course> courses = new ArrayList<Course>();
	private final List<Course> deletedCourses = new ArrayList<Course>();
	private final List<Student> students = new ArrayList<Student>();
	
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
	
	/**
	 * Enrole a {@link Student} to a {@link Course} 
	 * @param lvaIdentifier
	 * @param matrikelNumber
	 * @return true if the {@link Student} is successfully enroled, false otherwise
	 */
	public boolean enrole(String lvaIdentifier, String matrikelNumber) {

		Course course = getCourseFor(lvaIdentifier);
		Student student = getStudentFor(matrikelNumber);
		
		return course.registerStudent(student);
	}
	
	/**
	 * Reject a {@link Course} and inform them.
	 * @param courseIdentifier
	 */
	public void cancelCourse(String courseIdentifier) {
		Course course = getCourseFor(courseIdentifier);
		
		for (Student student : course.getStudents()) {
			informCanceled(student,course,"Course has been canceled");
		}
		
		deleteCourse(courseIdentifier);
	}
	
	private boolean informCanceled(Student student, Course course, String detail_message) {
		
		System.out.println("Info to " + student.getName() + ": " + course.getName() + " has been canceled!"); //TMP for now
		
		//TODO: send email?
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
		Student student = getStudentFor(matrikelNumber);
		
		return course.unregisterStudent(student);
	}

	/**
	 * 
	 * @param lvaIdentifier
	 * @return count of all {@link Student}s that have been created
	 */
	public int studentCountIn(String lvaIdentifier) {
		Course course = getCourseFor(lvaIdentifier);
		return course.getStudents().size();
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public List<Student> getStudents() {
		return students;
	}
	
	public void deleteCourse (String lvaIdentifier) {
		Course course = getCourseFor(lvaIdentifier);
		courses.remove(course);
		deletedCourses.add(course);
	}
	
	public void enableCourse (String lvaIdentifier) {
		Course course = getDeletedCourseFor(lvaIdentifier);
		deletedCourses.remove(course);
		courses.add(course);
	}
	
	private Course getDeletedCourseFor(String lvaIdentifier) {
		for (Course course : deletedCourses) {
			if (course.getLvaIdentifier().equals(lvaIdentifier)) {
				return course;
			}
		}
		
		throw new NoSuchElementException("Course '" + lvaIdentifier + "' does not exist");
	}
	
	private Course getCourseFor(String lvaIdentifier) {
		for (Course course : courses) {
			if (course.getLvaIdentifier().equals(lvaIdentifier)) {
				return course;
			}
		}
		
		throw new NoSuchElementException("Course '" + lvaIdentifier + "' does not exist");
	}
	
	private Student getStudentFor(String matrikelNumber) {
		for (Student student : students) {
			if (student.getMatrikelNumber().equals(matrikelNumber)) {
				return student;
			}
		}
		throw new NoSuchElementException("Student '" + matrikelNumber + "' does not exist");
	}

	public boolean pass(Student student, Registerable registerable) {
		if (registerable.getStudents().contains(student) && registerable.hasAchievement()) {
			student.addAchievements(registerable.getAchievement());
			return true;
		}
		
		return false;
	}
}
