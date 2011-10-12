import java.util.List;

import oopt.round1.Course;
import oopt.round1.CourseManager;
import oopt.round1.Student;


public class Test {

	public static void main(String[] args) {
		
		System.out.println("-Anlegen der Lehrveranstaltungen");
		
		//students
		CourseManager.createNewStudent("1025637", "Richard Plangger");
		CourseManager.createNewStudent("1025990", "Simon Zuend");
		CourseManager.createNewStudent("1025991", "Klaus Nigsch");
		CourseManager.createNewStudent("1046344", "Max Mustermann");
		CourseManager.createNewStudent("0232454", "Simon Stammler");
		CourseManager.createNewStudent("1034523", "Lukas Fleischhacker");
		CourseManager.createNewStudent("1025992", "Erzengel Gabriel");
		CourseManager.createNewStudent("0825993", "Morgan Freeman");
		CourseManager.createNewStudent("0025994", "John Rambo");
		CourseManager.createNewStudent("0025995", "Arnold Schwarzenegger");
		CourseManager.createNewStudent("1025996", "Albert Einstein");
		
		//courses
		CourseManager.createNewCourse("123.456", "Objektorientierte Programmiertechniken");
		CourseManager.createNewCourse("123.451", "Funktionale Programmierung");
		CourseManager.createNewCourse("133.412", "Statistik und Wahrscheinlichkeitsrechnung");
		CourseManager.createNewCourse("133.452", "Logikorientiere Programmierung");
		CourseManager.createNewCourse("173.432", "Mathematik 2");
		CourseManager.createNewCourse("133.451", "Daten- und Informatikrecht");
		
		//enrolements
		CourseManager.enrole("123.456","1025637");
		CourseManager.enrole("123.456","1025990");
		CourseManager.enrole("173.432","1025991");
		CourseManager.enrole("123.456","1034523");
		CourseManager.enrole("123.456","0025995");
		CourseManager.enrole("123.456","0025995");
		CourseManager.enrole("133.412","0025995");
		CourseManager.enrole("123.456","0025995");
		CourseManager.enrole("123.456","0025994");
		CourseManager.enrole("133.451","0825993");
		CourseManager.enrole("123.451","1025996");
		
		System.out.println("-Liste aller LVAs:");
		List<Course> courses = null;
		//list all course informations
		for (Course c : courses) {
			System.out.println(String.format(
					"%s : %s" +
					"\n\tAnmeldungbegin: %s" +
					"\n\tAnmeldungsende: %s" +
					"\n\tAbmeldungsende: %s",
					c.getLvaIdentifier(), 
					c.getName(), 
					c.getEarlyEnrol(),
					c.getLateEnrol(),
					c.getLateUnenrol())); 
		}
		
		//list all students that are enroled into any course
		List<Student> enroledStudents = null; //CourseManager.getStudents();
		for (Student student : enroledStudents) {
			System.out.println(String.format("%s %s",
					student.getMatrikelNumber(),
					student.getName()));
		}
	}
}
