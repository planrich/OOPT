import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

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
		Student arnold = universityService.createNewStudent("0025995", "Arnold Schwarzenegger");
		Student albert_einstein = universityService.createNewStudent("1025996", "Albert Einstein");


		//mathe 1
		Course mathe1 = universityService.createNewCourse("174.431", "Mathematik 1");
		mathe1.setLateEnrol(new Date(System.currentTimeMillis() + (3 * 60 * 60 * 24) * 100)); //in 3 days
		mathe1.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100)); //before 4 days
		mathe1.setLateUnenrol(new Date(System.currentTimeMillis() + (6 * 60 * 60 * 24) * 100)); //in 6 days
		
		//mathe 2
		Course mathe2 = universityService.createNewCourse("173.432", "Mathematik 2");
		mathe2.setLateEnrol(new Date(System.currentTimeMillis() + (3 * 60 * 60 * 24) * 100)); //in 3 days
		mathe2.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100)); //before 4 days
		mathe2.setLateUnenrol(new Date(System.currentTimeMillis() + (6 * 60 * 60 * 24) * 100)); //in 6 days
		
		Registerable mathe1_exam = new Exam("EI 7", new Date(), new Date());
		mathe1_exam.setLateEnrol(new Date(System.currentTimeMillis() + (3 * 60 * 60 * 24) * 100)); //in 3 days
		mathe1_exam.setEarlyEnrol(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 24) * 100)); //before 4 days
		mathe1_exam.setLateUnenrol(new Date(System.currentTimeMillis() + (6 * 60 * 60 * 24) * 100)); //in 6 days
		
		mathe1.add(mathe1_exam);
		Achievement mathe1_achieve = new Achievement(mathe1_exam, 6);
		mathe1_exam.setAchievement(mathe1_achieve);

		Restriction r = new Restriction();
		r.addAchievement(mathe1_achieve);
		mathe2.getRestrictions().add(r);
		
		//enrolements
		System.out.println("###Checking enrolements:");
		System.out.print("Registering Albert Einstein to Mathematik 1...");
		if (mathe1.registerStudent(albert_einstein)) {
			System.out.println("great success");
		} else {
			System.out.println("fails");
		}
		
		System.out.print("Registering Albert Einstein to Mathematik 1 Examination...");
		if (mathe1_exam.registerStudent(albert_einstein)) {
			System.out.println("great success");
		} else {
			System.out.println("fails");
		}
		
		System.out.print("Albert Einstein makes the Exam for Mathematik 1...");
		if (universityService.pass(albert_einstein, mathe1_exam)) {
			System.out.println("passes");
		} else {
			System.out.println("fails");
		}
		
		System.out.print("Albert Einstein is now ready for Mathematik 2...");
		if (mathe2.registerStudent(albert_einstein)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		
		System.out.print("Arnold now tries to enrole to Mathematik 2 without having made Mathematik 1 Examination...");
		if (mathe2.registerStudent(arnold)) {
			System.out.println("greate success");
		} else {
			System.out.println("fails so bad");
		}
		
		//delete a course
		System.out.println("###Checking deleting feature");
		System.out.println("Creating course Body Building");
		universityService.createNewCourse("123.333", "Body Building");
		System.out.println("Deleting course Body Building");
		universityService.deleteCourse("123.333");
		System.out.print("Arnold wants to enrole to Body Building...");
		try {
			universityService.enrole("123.333", "0025995");
			System.out.println("great success");
		} catch (NoSuchElementException e) {
			System.out.println("failed");
		}
		System.out.println("Poor Arnold -> enabling course again");
		universityService.enableCourse("123.333");
		System.out.print("Arnold wants to enrole _again_ to Body Building...");
		try {
			universityService.enrole("123.333", "0025995");
			System.out.println("great success");
		} catch (NoSuchElementException e) {
			System.out.println("failed");
		}
		
		//cancel
		System.out.println("###Checking cancel feature");
		universityService.enrole("123.333", "1025996");
		universityService.enrole("123.333", "1025637");
		universityService.enrole("123.333", "1025990");
		universityService.enrole("123.333", "1034523");
		System.out.println("Taking course Body Building and canceling it.");
		universityService.cancelCourse("123.333");
		
		
		
	}
}
