
public class RotaryArmRobot extends Robot {

	protected int armRotations;
	
	public RotaryArmRobot() {
		super();
		armRotations = 0;
	}
	
	public int getArmRotations() {
		return armRotations;
	}
	
	public void setArmRotations(int armRotations) {
		this.armRotations = armRotations;
	}
	
}
