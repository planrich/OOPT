
public class Mamba extends Snake {

	public Mamba(String name) {
		super(name);
	}

	@Override
	public boolean loadTo(Section section) {
		return section.load(this);
	}
}
