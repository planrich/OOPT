import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Representing a course at any university.
 * 
 * @author rich
 * @date 12.10.2011
 */

public class LVA {

	private final int lvaNumber;
	private final String name;
	private final List<Student> students;
	
	public LVA(int lvaNumber, String name) {
		this.lvaNumber = lvaNumber;
		this.name = name;
		this.students = new ArrayList<Student>();
	}
	
	public boolean enrole(Student s) {
		
		//TODO check dates
		Date now = new Date();
		
		return this.students.add(s);
	}
	
	@Override
	public int hashCode() {
		return lvaNumber;
	}
}
