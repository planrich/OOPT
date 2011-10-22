package oopt.round2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Registerable {
	
	protected final List<Restriction> restrictions = new ArrayList<Restriction>();
	
	protected Date earlyEnrol = new Date();
	protected Date lateEnrol = new Date();
	protected Date lateUnenrol = new Date();
	
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
