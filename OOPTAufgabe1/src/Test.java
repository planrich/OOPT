import java.util.Date;
import java.util.List;

import oopt.round1.Course;
import oopt.round1.CourseManager;
import oopt.round1.Student;


public class Test {

	public static void main(String[] args) {
		
		System.out.println("###Anlegen der Lehrveranstaltungen");
		
		CourseManager courseManager = new CourseManager();
		
		//students
		courseManager.createNewStudent("1025637", "Richard Plangger");
		courseManager.createNewStudent("1025990", "Simon Zuend");
		courseManager.createNewStudent("1025991", "Klaus Nigsch");
		courseManager.createNewStudent("1046344", "Max Mustermann");
		courseManager.createNewStudent("0232454", "Simon Stammler");
		courseManager.createNewStudent("1034523", "Lukas Fleischhacker");
		courseManager.createNewStudent("1025992", "Erzengel Gabriel");
		courseManager.createNewStudent("0825993", "John Rambo");
		courseManager.createNewStudent("0025994", "Morgan Freeman");
		courseManager.createNewStudent("0025995", "Arnold Schwarzenegger");
		courseManager.createNewStudent("1025996", "Albert Einstein");
		
		//courses
		Course course = courseManager.createNewCourse("123.456", "Objektorientierte Programmiertechniken");
		course.setLateEnrol(new Date(System.currentTimeMillis() + (10 * 60 * 60 * 24) * 100)); //in 10 days
		course.setLateUnenrol(new Date(System.currentTimeMillis() + (11 * 60 * 60 * 24) * 100)); //in 11 days
		course = courseManager.createNewCourse("123.451", "Funktionale Programmierung");
		course.setLateEnrol(new Date(System.currentTimeMillis() + (1 * 60 * 60 * 24) * 100)); //in 1 days
		course.setLateUnenrol(new Date(System.currentTimeMillis() + (10 * 60 * 60 * 24) * 100)); //in 10 days
		course = courseManager.createNewCourse("133.412", "Statistik und Wahrscheinlichkeitsrechnung");
		course.setLateEnrol(new Date(System.currentTimeMillis() + (2 * 60 * 60 * 24) * 100)); //in 2 days
		course.setLateUnenrol(new Date(System.currentTimeMillis() + (5 * 60 * 60 * 24) * 100)); //in 5 days
		course = courseManager.createNewCourse("133.452", "Logikorientiere Programmierung");
		course.setLateEnrol(new Date(System.currentTimeMillis() + (7 * 60 * 60 * 24) * 100)); //in 7 days
		course.setLateUnenrol(new Date(System.currentTimeMillis() + (10 * 60 * 60 * 24) * 100)); //in 10 days
		course = courseManager.createNewCourse("133.451", "Bodybuilding");
		course.setLateEnrol(new Date(System.currentTimeMillis() + (10 * 60 * 60 * 24) * 100)); //in 10 days
		course.setLateUnenrol(new Date(System.currentTimeMillis() + (10 * 60 * 60 * 24) * 100)); //in 10 days

		course = courseManager.createNewCourse("173.432", "Mathematik 2");
		course.setLateEnrol(new Date(System.currentTimeMillis() - (3 * 60 * 60 * 24) * 100)); //before 3 days
		course.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100)); //before 4 days
		course.setLateUnenrol(new Date(System.currentTimeMillis() + (2 * 60 * 60 * 24) * 100)); //in 2 days
		
		//enrolements
		System.out.println("###Checking enrolements in the valid enrolement timespan:");
		System.out.print(String.format("%s is trying to enrole to %s...","0025995","133.451"));
		if (courseManager.enrole("133.451","0025995")) {
			System.out.println("great success!");
		} else {
			System.out.println("failed");
		}
		System.out.print(String.format("%s is trying _again_ to enrole to %s...","0025995","133.451"));
		if (courseManager.enrole("133.451","0025995")) {
			System.out.println("great success!");
		} else {
			System.out.println("failed");
		}
		System.out.print(String.format("%s is trying to unenrole from %s...","0025995","133.451"));
		if (courseManager.unenrole("133.451","0025995")) {
			System.out.println("great success!");
		} else {
			System.out.println("failed");
		}
		
		courseManager.enrole("173.432","1025991");
		courseManager.enrole("123.456","1025637");
		courseManager.enrole("123.456","1025990");
		courseManager.enrole("123.456","1034523");
		courseManager.enrole("123.456","0025995");
		courseManager.enrole("123.456","0025995");
		courseManager.enrole("133.412","0025995");
		courseManager.enrole("123.456","0025995");
		courseManager.enrole("123.456","0025994");
		courseManager.enrole("133.451","0825993");
		courseManager.enrole("123.451","1025996");
		
		System.out.println("###Liste aller LVAs:");
		List<Course> courses = courseManager.getCourses();
		//list all course informations
		for (Course c : courses) {
			
			int size = courseManager.studentCountIn(c.getLvaIdentifier());
			
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
		
		System.out.println("###Liste aller Studenten:");
		//list all students that are enroled into any course
		List<Student> enroledStudents = courseManager.getStudents();
		for (Student student : enroledStudents) {
			System.out.println(String.format("%s %s",
					student.getMatrikelNumber(),
					student.getName()));
		}
	}
}
