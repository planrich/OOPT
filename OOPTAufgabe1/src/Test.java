import java.util.Date;
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
		Course course = CourseManager.createNewCourse("123.456", "Objektorientierte Programmiertechniken");
		course.setLateEnrol(new Date(System.currentTimeMillis() + (10 * 60 * 60 * 24) * 100)); //in 10 days
		course.setLateUnenrol(new Date(System.currentTimeMillis() + (11 * 60 * 60 * 24) * 100)); //in 11 days
		course = CourseManager.createNewCourse("123.451", "Funktionale Programmierung");
		course.setLateEnrol(new Date(System.currentTimeMillis() + (1 * 60 * 60 * 24) * 100)); //in 1 days
		course.setLateUnenrol(new Date(System.currentTimeMillis() + (10 * 60 * 60 * 24) * 100)); //in 10 days
		course = CourseManager.createNewCourse("133.412", "Statistik und Wahrscheinlichkeitsrechnung");
		course.setLateEnrol(new Date(System.currentTimeMillis() + (2 * 60 * 60 * 24) * 100)); //in 2 days
		course.setLateUnenrol(new Date(System.currentTimeMillis() + (5 * 60 * 60 * 24) * 100)); //in 5 days
		course = CourseManager.createNewCourse("133.452", "Logikorientiere Programmierung");
		course.setLateEnrol(new Date(System.currentTimeMillis() + (7 * 60 * 60 * 24) * 100)); //in 7 days
		course.setLateUnenrol(new Date(System.currentTimeMillis() + (10 * 60 * 60 * 24) * 100)); //in 10 days
		course = CourseManager.createNewCourse("133.451", "Daten- und Informatikrecht");
		course.setLateEnrol(new Date(System.currentTimeMillis() + (10 * 60 * 60 * 24) * 100)); //in 10 days
		course.setLateUnenrol(new Date(System.currentTimeMillis() + (10 * 60 * 60 * 24) * 100)); //in 10 days

		course = CourseManager.createNewCourse("173.432", "Mathematik 2");
		course.setLateEnrol(new Date(System.currentTimeMillis() - (3 * 60 * 60 * 24) * 100)); //before 3 days
		course.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100)); //before 4 days
		course.setLateUnenrol(new Date(System.currentTimeMillis() + (2 * 60 * 60 * 24) * 100)); //in 2 days
		
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
			
			int size = 0;
			
			System.out.println(String.format(
					"%s : %s" +
					"\n\tAnmeldungbegin: %s" +
					"\n\tAnmeldungsende: %s" +
					"\n\tAbmeldungsende: %s" +
					"\n\tAnzahl der angemeldeten Studenten: %d",
					c.getLvaIdentifier(), 
					c.getName(), 
					c.getEarlyEnrol(),
					c.getLateEnrol(),
					c.getLateUnenrol(),
					size)); 
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
