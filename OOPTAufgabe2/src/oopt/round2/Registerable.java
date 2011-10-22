package oopt.round2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Registerable {
	
	protected final List<Restriction> restrictions = new ArrayList<Restriction>();
	protected final List<Student> students = new ArrayList<Student>();
	
	protected Date earlyEnrol = new Date();
	protected Date lateEnrol = new Date();
	protected Date lateUnenrol = new Date();
	
	public boolean registerStudent(Student student) {
		Date now = new Date();
		if (now.before(earlyEnrol) || now.after(lateEnrol)) {
			return false;
		}
		
		// TODO: check here for restriction
		
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
