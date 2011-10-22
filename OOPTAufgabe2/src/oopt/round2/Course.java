package oopt.round2;



/**
 * Representing a course at any university.
 * 
 * @author rich
 * @date 12.10.2011
 */
public class Course extends Registerable {
	
	private String lvaIdentifier;
	private String name;
	
	public Course(String lvaIdentifier, String name) {
		if (lvaIdentifier == null || name == null) {
			throw new IllegalArgumentException("Constructor arguments must not be null.");
		}
		
		this.lvaIdentifier = lvaIdentifier;
		this.name = name;
	}

	public String getLvaIdentifier() {
		return lvaIdentifier;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return lvaIdentifier.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj instanceof Course) {
			Course course = (Course) obj;
			return course.getLvaIdentifier().equals(this.lvaIdentifier);
		}
		return false;
	}
}
