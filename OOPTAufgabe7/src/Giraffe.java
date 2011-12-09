
public class Giraffe extends BigGame {

	public Giraffe(String name) {
		super(name);
	}

	/**
	 * Can never load an {@link Giraffe} to a section
	 */
	@Override
	public boolean loadTo(Section section) {
		return false;
	}
	
}
