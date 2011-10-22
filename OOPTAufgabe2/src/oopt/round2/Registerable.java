package oopt.round2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Registerable {
	
	private final List<Restriction> restrictions = new ArrayList<Restriction>();
	private final List<Student> students = new ArrayList<Student>();
	
	private Date earlyEnrol = new Date();
	private Date lateEnrol = new Date();
	private Date lateUnenrol = new Date();
	
	public boolean registerStudent(Student student) {
		Date now = new Date();
		if (now.before(earlyEnrol) || now.after(lateEnrol)) {
			return false;
		}
		
		for (Restriction restriction : restrictions) {
			if (!restriction.checkRestrictionsFor(student)) {
				return false;
			}
		}
		
		return students.add(student);
	}
	
	public boolean unregisterStudent(Student student) {
		if (!students.contains(student)) {
			return false;
		}
		
		Date now = new Date();
		if (now.after(lateUnenrol)) {
			return false;
		}
		
		return students.remove(student);
	}
	
	public List<Student> getStudents() {
		return students;
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
}
