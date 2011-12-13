
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
	public Mamba unloadMamba() {
		return null;
	}

	@Override
	public Python unloadPython() {
		return null;
	}

	@Override
	public BigTurtle unloadBigTurtle() {
		Animal a = this.animal;
		this.animal = null;
		return (BigTurtle) a;
	}

	@Override
	public SmallTurtle unloadSmallTurtle() {
		Animal a = this.animal;
		this.animal = null;
		return (SmallTurtle) a;
	}
}
