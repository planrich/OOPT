
public class SwivelArmRobot extends Robot {

	private int rotations;
	
	public SwivelArmRobot(int number) {
		super(number);
		rotations = 0;
	}

	public void addRotations(int rotations) {
		this.rotations += rotations;
	}
	
	public int getRotations() {
		return rotations;
	}
}
