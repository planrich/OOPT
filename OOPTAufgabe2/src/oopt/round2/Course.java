package oopt.round2;

import java.util.Date;

/**
 * Representing a course at any university.
 * 
 * @author rich
 * @date 12.10.2011
 */
public class Course {

	private final String lvaIdentifier;
	private final String name;
	
	private Date earlyEnrol = new Date();
	private Date lateEnrol = new Date();
	private Date lateUnenrol = new Date();
	
	public Course(String lvaIdentifier, String name) {
		if (lvaIdentifier == null || name == null) {
			throw new IllegalArgumentException("Invalid argument in constructors. Must not be null.");
		}
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
	
	@Override
	public int hashCode() {
		return lvaIdentifier.hashCode();
	}

	public Date getEarlyEnrol() {
		return earlyEnrol;
	}

	public void setEarlyEnrol(Date earlyEnrol) {
		this.earlyEnrol = earlyEnrol;
	}

	public Date getLateEnrol() {
		return lateEnrol;
	}

	public void setLateEnrol(Date lateEnrol) {
		this.lateEnrol = lateEnrol;
	}

	public Date getLateUnenrol() {
		return lateUnenrol;
	}

	public void setLateUnenrol(Date lateUnenrol) {
		this.lateUnenrol = lateUnenrol;
	}

	public String getLvaIdentifier() {
		return lvaIdentifier;
	}

	public String getName() {
		return name;
	}
}
