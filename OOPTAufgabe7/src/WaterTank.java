
/**
 * Can load any {@link SeeAnimal} but not a {@link Seal}
 * @author klaus
 */
public class WaterTank extends Tank {

	@Override
	public boolean loadDolphin(Dolphin dolphin) {
		if (this.animal != null) {
			return false;
		}
		this.animal = dolphin;
		return true;
	}

	@Override
	public boolean loadSwordfish(Swordfish swordfish) {
		if (this.animal != null) {
			return false;
		}
		this.animal = swordfish;
		return true;
	}

	@Override
	public boolean loadSeal(Seal seal) {
		return false;
	}
}
