
public class BigTurtleTerrarium extends Terrarium {

	@Override
	public boolean loadMamba(Mamba mamba) {
		return false;
	}

	@Override
	public boolean loadPython(Python python) {
		return false;
	}

	@Override
	public boolean loadBigTurtle(BigTurtle turtle) {
		if (this.animal != null) {
			return false;
		}
		this.animal = turtle;
		return true;
	}

	@Override
	public boolean loadSmallTurtle(SmallTurtle turtle) {
		if (this.animal != null) {
			return false;
		}
		this.animal = turtle;
		return true;
	}
}
