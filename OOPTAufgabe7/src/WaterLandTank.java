
/**
 * A {@link WaterLandTank} can load any {@link SeeAnimal}
 * @author klaus
 */
public class WaterLandTank extends Tank {

	public boolean load(SeeAnimal seeAnimal) {
		this.animal = seeAnimal;
		return true;
	}
}
