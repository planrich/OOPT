
public class Elefant extends BigGame {

	public Elefant(String name) {
		super(name);
	}
	
	/**
	 * Can never load an {@link Elefant} to a section
	 */
	@Override
	public boolean loadTo(Section section) {
		return false;
	}
}
