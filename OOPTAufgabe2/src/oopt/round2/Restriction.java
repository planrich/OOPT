package oopt.round2;

import java.util.List;
import java.util.ArrayList;
// abfragen, ob Student Restrictions erfüllt
public class Restriction {
	
	public List<Achievement> achievements = new ArrayList<Achievement>();

	public Restriction() {	
	}
	
	public void addAchievement(Achievement achievement) {
		achievements.add(achievement);
	}
}
