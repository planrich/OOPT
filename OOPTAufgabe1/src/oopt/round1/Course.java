package oopt.round1;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Representing a course at any university.
 * 
 * @author rich
 * @date 12.10.2011
 */
public class Course {

	private final String lvaIdentifier;
	private final String name;
	private final List<Student> students;
	
	public Course(String lvaIdentifier, String name) {
		this.lvaIdentifier = lvaIdentifier;
		this.name = name;
		this.students = new ArrayList<Student>();
	}
	
	public boolean enrole(Student s) {
		
		//TODO check dates
		Date now = new Date();
		
		return this.students.add(s);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Course) {
			Course course = (Course) obj;
			return course.lvaIdentifier.equals(this.lvaIdentifier);
		}
		return false;
	}
}
