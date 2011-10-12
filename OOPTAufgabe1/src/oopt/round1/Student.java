package oopt.round1;

/**
 * A student at any university
 * 
 * @author rich
 * @date 12.10.2011
 */
public class Student {

	private final String matrikelNumber;
	private final String name;
	
	public Student(String matrikelNumber, String name) {
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
}
