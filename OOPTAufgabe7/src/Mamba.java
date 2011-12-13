
public class Mamba extends Snake {

	public Mamba(String name) {
		super(name);
	}

	@Override
	public boolean load(Section section) {
		return section.loadMamba(this);
	}
}
