
public class SmallTurtle extends Turtle {

	public SmallTurtle(String name) {
		super(name);
	}

	@Override
	public boolean loadTo(Section section) {
		return section.load(this);
	}

}
