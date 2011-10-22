package oopt.round2;

import java.util.Date;

public class Exam extends Registerable {

	private String room;
	private Date start;
	private Date end;
	
	public Exam(String room, Date start, Date end) {
		if (room == null || start == null || end == null) {
			throw new IllegalArgumentException("Constructor parameters must not be null.");
		}
		this.room = room;
		this.start = start;
		this.end = end;
	}
}
