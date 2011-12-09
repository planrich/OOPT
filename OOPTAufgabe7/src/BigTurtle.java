
public class BigTurtle extends Turtle {

	public BigTurtle(String name) {
		super(name);
	}
	
	@Override
	public boolean loadTo(Section section) {
		return section.load(this);
	}
}
