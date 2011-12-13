
public class Swordfish extends SeeAnimal {

	public Swordfish(String name) {
		super(name);
	}

	@Override
	public boolean load(Section section) {
		return section.loadSwordfish(this);
	}
}
