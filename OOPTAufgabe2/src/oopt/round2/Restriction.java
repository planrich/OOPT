package oopt.round2;

import java.util.List;
import java.util.ArrayList;
// abfragen, ob Student Restrictions erfüllt
public class Restriction {
	
	private List<Achievement> achievements = new ArrayList<Achievement>();

	public Restriction() {	
	}
	
	public void addAchievement(Achievement achievement) {
		achievements.add(achievement);
	}
	
	public List<Achievement> getAchievements() {
		return achievements; 
	}
	
	public boolean checkRestrictionsFor(Student student) {
		List<Achievement> studentAchievements = student.getAchievements();
		if(achievements.containsAll(studentAchievements)) {
			return true;
		}
		return false;
	}
}
