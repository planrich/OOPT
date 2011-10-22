package oopt.round2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Registerable {

	protected final String lvaIdentifier;
	protected final String name;
	
	protected final List<Restriction> restrictions;
	
	protected Date earlyEnrol = new Date();
	protected Date lateEnrol = new Date();
	protected Date lateUnenrol = new Date();
	
	public Registerable(String lvaIdentifier, String name) {
		if (lvaIdentifier == null || name == null) {
			throw new IllegalArgumentException("Invalid argument in constructors. Must not be null.");
		}
		this.lvaIdentifier = lvaIdentifier;
		this.name = name;
		this.restrictions = new ArrayList<Restriction>();
	}
	
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Registerable) {
			Registerable r = (Registerable) obj;
			return r.lvaIdentifier.equals(this.lvaIdentifier);
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
