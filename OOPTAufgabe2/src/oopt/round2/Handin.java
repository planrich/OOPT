package oopt.round2;

import java.util.Date;

public class Handin extends Exam {

	private String tutor;
	
	public Handin(String room, Date start, Date end, String tutor) {
		super(room, start, end);
		if (tutor == null) {
			throw new IllegalArgumentException("Constructor arguments must not be null.");
		}
		this.tutor = tutor;
	}
}
