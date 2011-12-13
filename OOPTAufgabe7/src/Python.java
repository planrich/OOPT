
public class Python extends Snake {

	public Python(String name) {
		super(name);
	}

	@Override
	public boolean load(Container container) {
		return container.loadPython(this);
	}
}
