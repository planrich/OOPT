
public class MambaTerrarium extends Terrarium {

	@Override
	public boolean loadMamba(Mamba mamba) {
		if (this.animal != null) {
			return false;
		}
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
