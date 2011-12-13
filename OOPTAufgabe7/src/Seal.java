
public class Seal extends SeeAnimal {

	public Seal(String name) {
		super(name);
	}

	@Override
	public boolean load(Section section) {
		return section.loadSeal(this);
	}
}
