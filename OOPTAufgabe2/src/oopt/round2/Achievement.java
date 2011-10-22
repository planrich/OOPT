package oopt.round2;

public class Achievement {
	
	private final int ects; 	//ECTS Credits
	private final Registerable target;
	
	
	public Achievement(Registerable registerable, int credits) {
		this.target = registerable;
		this.ects = credits;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj instanceof Achievement) {
			Achievement achievement = (Achievement) obj;
			return (achievement.ects == this.ects) && achievement.target.equals(this.target);
		}
		return false;
	}
}
