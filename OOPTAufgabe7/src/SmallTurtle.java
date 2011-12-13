
public class SmallTurtle extends Turtle {

	public SmallTurtle(String name) {
		super(name);
	}

	@Override
	public boolean load(Container container) {
		return container.loadSmallTurtle(this);
	}

}
