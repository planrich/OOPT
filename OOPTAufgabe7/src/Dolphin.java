
public class Dolphin extends SeeAnimal {

	public Dolphin(String name) {
		super(name);
	}


	@Override
	public boolean load(Section section) {
		return section.loadDolphin(this);
	}
}
