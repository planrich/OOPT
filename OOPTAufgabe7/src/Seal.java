
public class Seal extends SeeAnimal {

	public Seal(String name) {
		super(name);
	}

	@Override
	public boolean load(Container container) {
		return container.loadSeal(this);
	}
}
