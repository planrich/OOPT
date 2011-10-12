package oopt.round1;

/**
 * Representing a course at any university.
 * 
 * @author rich
 * @date 12.10.2011
 */
public class Course {

	private final String lvaIdentifier;
	private final String name;
	
	public Course(String lvaIdentifier, String name) {
		this.lvaIdentifier = lvaIdentifier;
		this.name = name;
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
