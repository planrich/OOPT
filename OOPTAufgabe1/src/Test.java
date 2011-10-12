import oopt.round1.Course;
import oopt.round1.Student;


public class Test {

	public static void main(String[] args) {
		Course lva = new Course("198762", "Objektorientierte Programmiertechniken");
		lva.enrole(new Student(1025637, "Richard Plangger"));
	}
}
