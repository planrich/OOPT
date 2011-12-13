
public class PythonTerrarium extends Terrarium {

	@Override
	public boolean loadMamba(Mamba mamba) {
		this.animal = mamba;
		return true;
	}

	@Override
	public boolean loadPython(Python python) {
		this.animal = python;
		return true;
	}

	@Override
	public boolean loadBigTurtle(BigTurtle turtle) {
		return false;
	}

	@Override
	public boolean loadSmallTurtle(SmallTurtle turtle) {
		return false;
	}

	@Override
	public Mamba unloadMamba() {
		Animal a = this.animal;
		this.animal = null;
		return (Mamba) a;
	}

	@Override
	public Python unloadPython() {
		Animal a = this.animal;
		this.animal = null;
		return (Python) a;
	}

	@Override
	public BigTurtle unloadBigTurtle() {
		return null;
	}

	@Override
	public SmallTurtle unloadSmallTurtle() {
		return null;
	}
}
