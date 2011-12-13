
public class Dolphin extends SeeAnimal {

	public Dolphin(String name) {
		super(name);
	}

	@Override
	public boolean load(Container container) {
		return container.loadDolphin(this);
	}
}
