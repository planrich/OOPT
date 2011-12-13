
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
}
