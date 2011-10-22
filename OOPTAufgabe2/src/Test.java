import java.util.Date;
import java.util.List;

import oopt.round2.Achievement;
import oopt.round2.Course;
import oopt.round2.Exam;
import oopt.round2.Registerable;
import oopt.round2.Restriction;
import oopt.round2.Student;
import oopt.round2.UniversityService;


public class Test {

	public static void main(String[] args) {
		
		System.out.println("###Anlegen der Lehrveranstaltungen");
		
		UniversityService universityService = new UniversityService();
		
		//students
		universityService.createNewStudent("1025637", "Richard Plangger");
		universityService.createNewStudent("1025990", "Simon Zuend");
		universityService.createNewStudent("1025991", "Klaus Nigsch");
		universityService.createNewStudent("1046344", "Max Mustermann");
		universityService.createNewStudent("0232454", "Simon Stammler");
		universityService.createNewStudent("1034523", "Lukas Fleischhacker");
		universityService.createNewStudent("1025992", "Erzengel Gabriel");
		universityService.createNewStudent("0825993", "John Rambo");
		universityService.createNewStudent("0025994", "Morgan Freeman");
		universityService.createNewStudent("0025995", "Arnold Schwarzenegger");
		Student albert_einstein = universityService.createNewStudent("1025996", "Albert Einstein");

		Course mathe2 = universityService.createNewCourse("173.432", "Mathematik 2");
		mathe2.setLateEnrol(new Date(System.currentTimeMillis() - (3 * 60 * 60 * 24) * 100)); //before 3 days
		mathe2.setEarlyEnrol(new Date(System.currentTimeMillis() + (4 * 60 * 60 * 24) * 100)); //in 4 days
		mathe2.setLateUnenrol(new Date(System.currentTimeMillis() + (6 * 60 * 60 * 24) * 100)); //in 6 days
		
		Course mathe1 = universityService.createNewCourse("174.431", "Mathematik 1");
		Registerable mathe1_exam = new Exam("EI 7", new Date(), new Date());
		mathe1.add(mathe1_exam);
		Achievement mathe1_achieve = new Achievement(mathe1_exam, 6);
		mathe1_exam.setAchievement(mathe1_achieve);

		mathe2.getRestrictions().addAchievement(mathe1_achieve);
		
		//enrolements
		System.out.println("###Checking enrolements in the valid enrolement timespan:");
		System.out.print(String.format("%s is trying to enrole to %s...","0025995","133.451"));
		if (universityService.enrole("174.431","1025996")) {
			System.out.println("great success!");
		} else {
			System.out.println("failed");
		}
		
		
		universityService.pass(albert_einstein, mathe1_exam);
		
		universityService.enrole("173.432","1025991");
		universityService.enrole("123.456","1025637");
		universityService.enrole("123.456","1025990");
		universityService.enrole("123.456","1034523");
		universityService.enrole("123.456","0025995");
		universityService.enrole("123.456","0025995");
		universityService.enrole("133.412","0025995");
		universityService.enrole("123.456","0025995");
		universityService.enrole("123.456","0025994");
		universityService.enrole("133.451","0825993");
		universityService.enrole("123.451","1025996");
		
		System.out.println("###Liste aller LVAs:");
		List<Course> courses = universityService.getCourses();
		//list all course informations
		for (Course c : courses) {
			
			int size = universityService.studentCountIn(c.getLvaIdentifier());
			
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
		List<Student> enroledStudents = universityService.getStudents();
		for (Student student : enroledStudents) {
			System.out.println(String.format("%s %s",
					student.getMatrikelNumber(),
					student.getName()));
		}
	}
}
