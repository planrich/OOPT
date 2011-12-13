
public class Mamba extends Snake {

	public Mamba(String name) {
		super(name);
	}

	@Override
	public boolean load(Container container) {
		return container.loadMamba(this);
	}
}
