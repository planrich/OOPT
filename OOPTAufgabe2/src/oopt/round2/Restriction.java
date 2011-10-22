package oopt.round2;

import java.util.ArrayList;
import java.util.List;


public class Restriction {
	
	private List<Achievement> achievements = new ArrayList<Achievement>();
	private String name;
	
	public Restriction(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Constructor argument must not be null.");
		}
		this.name = name;
	}
	
	public void addAchievement(Achievement achievement) {
		achievements.add(achievement);
	}
	
	public List<Achievement> getAchievements() {
		return achievements; 
	}
	
	public boolean checkRestrictionsFor(Student student) {
		List<Achievement> studentAchievements = student.getAchievements();
		if(studentAchievements.containsAll(achievements)) {
			return true;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj instanceof Restriction) {
			Restriction restriction = (Restriction) obj;
			return this.name.equals(restriction.name) && this.achievements.equals(restriction.achievements);
		}
		return false;
	}
}
