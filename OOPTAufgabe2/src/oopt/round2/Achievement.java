package oopt.round2;

public class Achievement {
	
	private final int ects; 	//ECTS Credits
	private final Registerable target;
	
	
	public Achievement(Registerable registerable, int credits) {
		this.target = registerable;
		this.ects = credits;
	}
}
