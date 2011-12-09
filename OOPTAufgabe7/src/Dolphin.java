
public class Dolphin extends SeeAnimal {

	public Dolphin(String name) {
		super(name);
	}


	@Override
	public boolean loadTo(Section section) {
		return section.load(this);
	}
	

}
