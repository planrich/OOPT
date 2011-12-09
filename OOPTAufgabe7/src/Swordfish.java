
public class Swordfish extends SeeAnimal {

	public Swordfish(String name) {
		super(name);
	}

	@Override
	public boolean loadTo(Section section) {
		return section.load(this);
	}
}
