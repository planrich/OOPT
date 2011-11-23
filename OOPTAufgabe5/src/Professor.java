
public class Professor extends Person {

	private String institut;
	
	public Professor(String name, String institut) {
		super(name);
		this.institut = institut;
	}

	public String getInstitut() {
		return institut;
	}
}
