import java.util.List;

import oopt.round1.Course;
import oopt.round1.CourseManager;
import oopt.round1.Student;


public class Test {

	public static void main(String[] args) {
		
		System.out.println("-Anlegen der Lehrveranstaltungen");
		
		CourseManager.createNewStudent(new Student("1025637", "Richard Plangger"));
		CourseManager.createNewStudent(new Student("1025990", "Simon Zuend"));
		CourseManager.createNewStudent(new Student("1025991", "Klaus Nigsch"));
		CourseManager.createNewStudent(new Student("1046344", "Max Mustermann"));
		CourseManager.createNewStudent(new Student("0232454", "Simon Stammler"));
		CourseManager.createNewStudent(new Student("1034523", "Lukas Fleischhacker"));
		CourseManager.createNewStudent(new Student("1025992", "Gabriel"));
		CourseManager.createNewStudent(new Student("0825993", "Morgan Freeman"));
		CourseManager.createNewStudent(new Student("0025994", "John Rambo"));
		CourseManager.createNewStudent(new Student("0025995", "Arnold Schwarzenegger"));
		CourseManager.createNewStudent(new Student("1025996", "Albert Einstein"));
		
		CourseManager.createNewCourse("123.456", "Objektorientierte Programmiertechniken");
		CourseManager.createNewCourse("123.451", "Funktionale Programmierung");
		CourseManager.createNewCourse("133.412", "Statistik und Wahrscheinlichkeitsrechnung");
		CourseManager.createNewCourse("133.452", "Logikorientiere Programmierung");
		CourseManager.createNewCourse("173.432", "Mathematik 2");
		CourseManager.createNewCourse("133.451", "Daten- und Informatikrecht");
		
		CourseManager.enrole("","");
		
		System.out.println("-Liste aller LVAs:");
		List<Course> courses = null;
		//list all course informations
		for (Course c : courses) {
			System.out.println(String.format("",)); 
		}
		
		//list all students that are enroled into any course
		List<Student> enroledStudents = null; //CourseManager.getStudents();
		for (Student student : enroledStudents) {
			System.out.println(student);
		}
	}
}
