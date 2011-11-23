
public class Student extends Person {

	private int matrikelnummer;
	
	public Student(String name, int matrikelnummer) {
		super(name);
		this.matrikelnummer = matrikelnummer;
	}
	
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
}
