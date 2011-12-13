
public abstract class Terrarium extends Section {
	
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
	
	@Override
	public Dolphin unloadDolphin() {
		return null;
	}

	@Override
	public Swordfish unloadSwordfish() {
		return null;
	}

	@Override
	public Seal unloadSeal() {
		return null;
	}
}
