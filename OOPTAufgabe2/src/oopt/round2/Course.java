package oopt.round2;

import java.util.ArrayList;
import java.util.List;


/**
 * Representing a course at any university.
 * 
 * @author rich
 * @date 12.10.2011
 */
public class Course extends Registerable {

	private final List<Registerable> related;
	
	public enum State {
		DEFAULT, DELETED; 
	}
	
	private State state;
	
	public Course(String lvaIdentifier, String name) {
		super(lvaIdentifier,name);
		this.state = State.DEFAULT;
		this.related = new ArrayList<Registerable>();
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State status) {
		this.state = status;
	}
}
