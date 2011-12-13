
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
		this.animal = turtle;
		return true;
	}

	@Override
	public boolean loadSmallTurtle(SmallTurtle turtle) {
		this.animal = turtle;
		return true;
	}

	@Override
	public boolean loadDolphin(Dolphin dolphin) {
		return false;
	}

	@Override
	public boolean loadSwordfish(Swordfish swordfish) {
		return false;
	}

	@Override
	public boolean loadSeal(Seal seal) {
		return false;
	}
}
