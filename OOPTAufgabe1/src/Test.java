import java.util.List;

import oopt.round1.Course;
import oopt.round1.CourseManager;
import oopt.round1.Student;


public class Test {

	public static void main(String[] args) {
		
		System.out.println("-Anlegen der Lehrveranstaltungen");
		
		Course oopt = CourseManager.createNewCourse("123456", "Objektorientierten Programmiertechniken");
		oopt.enrole(new Student(1025637, "Richard Plangger"));
		oopt.enrole(new Student(1025990, "Simon Zuend"));
		oopt.enrole(new Student(1025991, "Klaus Nigsch"));
		
		System.out.println("-Liste aller LVAs:");
		List<Course> courses = null;
		//list all course informations
		for (Course c : courses) {
			System.out.println(c); 
		}
		
		//list all students that are enroled into any course
		List<Student> enroledStudents = null; //CourseManager.getStudents();
		for (Student student : enroledStudents) {
			System.out.println(student);
		}
	}
}
