
public class MambaTerrarium extends Terrarium {

	@Override
	public boolean loadMamba(Mamba mamba) {
		this.animal = mamba;
		return true;
	}

	@Override
	public boolean loadPython(Python python) {
		return false;
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
