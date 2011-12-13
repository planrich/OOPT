
public class BigTurtle extends Turtle {

	public BigTurtle(String name) {
		super(name);
	}
	
	@Override
	public boolean load(Container container) {
		return container.loadBigTurtle(this);
	}
}
