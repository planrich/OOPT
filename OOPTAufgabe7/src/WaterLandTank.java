
/**
 * A {@link WaterLandTank} can load any {@link SeeAnimal}
 * @author klaus
 */
public class WaterLandTank extends WaterTank {

	@Override
	public boolean loadSeal(Seal seal) {
		if (this.animal != null) {
			return false;
		}
		this.animal = seal;
		return true;
	}
}
