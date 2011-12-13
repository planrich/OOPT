
public class Swordfish extends SeeAnimal {

	public Swordfish(String name) {
		super(name);
	}

	@Override
	public boolean load(Container container) {
		return container.loadSwordfish(this);
	}
}
