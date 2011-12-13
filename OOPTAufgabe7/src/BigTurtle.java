
public class BigTurtle extends Turtle {

	public BigTurtle(String name) {
		super(name);
	}
	
	@Override
	public boolean load(Section section) {
		return section.loadBigTurtle(this);
	}
}
