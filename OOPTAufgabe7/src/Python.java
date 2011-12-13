
public class Python extends Snake {

	public Python(String name) {
		super(name);
	}

	@Override
	public boolean load(Section section) {
		return section.loadPython(this);
	}
}
