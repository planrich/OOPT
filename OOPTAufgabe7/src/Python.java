
public class Python extends Snake {

	public Python(String name) {
		super(name);
	}

	@Override
	public boolean loadTo(Section section) {
		return section.load(this);
	}
}
