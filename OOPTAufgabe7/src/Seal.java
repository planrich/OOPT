
public class Seal extends SeeAnimal {

	public Seal(String name) {
		super(name);
	}

	@Override
	public boolean loadTo(Section section) {
		return section.load(this);
	}

}
