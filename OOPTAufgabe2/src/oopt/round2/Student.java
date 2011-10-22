package oopt.round2;

import java.util.List;
import java.util.ArrayList;

/**
 * A student at any university
 * 
 * @author rich
 * @date 12.10.2011
 */
public class Student {

	private final String matrikelNumber;
	private final String name;
	
	private List<Achievement> achievements = new ArrayList<Achievement>();
	
	public Student(String matrikelNumber, String name) {
		if (matrikelNumber == null || name == null) {
			throw new IllegalArgumentException("Invalid argument in constructors. Must not be null.");
		}
		this.matrikelNumber = matrikelNumber;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Student) {
			Student student = (Student) obj;
			return student.matrikelNumber.equals(this.matrikelNumber);
		}
		return false;
	}

	public String getMatrikelNumber() {
		return matrikelNumber;
	}

	public String getName() {
		return name;
	}
	
	public void addAchievements(Achievement achievement) {
		achievements.add(achievement);
	}
	
	public List<Achievement> getAchievements() {
		return achievements;
	}
}
