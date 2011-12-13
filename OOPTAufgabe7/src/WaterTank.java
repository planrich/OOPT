
/**
 * Can load any {@link SeeAnimal} but not a {@link Seal}
 * @author klaus
 */
public class WaterTank extends Tank {

	@Override
	public boolean loadDolphin(Dolphin dolphin) {
		this.animal = dolphin;
		return true;
	}

	@Override
	public boolean loadSwordfish(Swordfish swordfish) {
		this.animal = swordfish;
		return true;
	}

	@Override
	public boolean loadSeal(Seal seal) {
		return false;
	}

	@Override
	public Dolphin unloadDolphin() {
		Dolphin dolphin = (Dolphin) this.animal;
		this.animal = null;
		return dolphin;
	}

	@Override
	public Swordfish unloadSwordfish() {
		Swordfish swordFish = (Swordfish) this.animal;
		this.animal = null;
		return swordFish;
	}

	@Override
	public Seal unloadSeal() {
		return null;
	}
}
