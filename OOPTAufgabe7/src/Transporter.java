import java.util.ArrayList;
import java.util.List;


public class Transporter {
	private final List<Animal> animals = new ArrayList<Animal>();
	private Transporter followingTransporter;
	
	public void setFollowingTransporter(Transporter followingTransporter) {
		this.followingTransporter = followingTransporter;
	}
	
	/**
	 * This transporter must not be a pulling vehicle
	 * @return all {@link Animal}s from this transporter and all following ones.
	 */
	public List<Animal> list() {
		List<Animal> list = new ArrayList<Animal>();
		
		list.addAll(animals);
		
		list.addAll(followingTransporter.list());
		
		return list;
	}
}
