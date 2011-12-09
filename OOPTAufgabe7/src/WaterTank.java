
/**
 * Can load any {@link SeeAnimal} but not a {@link Seal}
 * @author klaus
 */
public class WaterTank extends Tank {

	public boolean load(Dolphin dolphin) {
		this.animal = dolphin;
		return true;
	}
	
	public boolean load(Swordfish swordfish) {
		this.animal = swordfish;
		return true;
	}

}
