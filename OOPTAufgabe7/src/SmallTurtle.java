
public class SmallTurtle extends Turtle {

	public SmallTurtle(String name) {
		super(name);
	}

	@Override
	public boolean load(Section section) {
		return section.loadSmallTurtle(this);
	}

}
