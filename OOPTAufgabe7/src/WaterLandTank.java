
/**
 * A {@link WaterLandTank} can load any {@link SeeAnimal}
 * @author klaus
 */
public class WaterLandTank extends WaterTank {

	@Override
	public boolean loadSeal(Seal seal) {
		this.animal = seal;
		return true;
	}
	
	@Override
	public Seal unloadSeal() {
		Seal seal = (Seal) this.animal;
		this.animal = null;
		return seal;
	}
}
