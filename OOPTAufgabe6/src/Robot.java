
public abstract class Robot {

	private static int uniqueID = 0;
	
	protected final int identification;
	protected int workingHours;
	
	protected Tool currentWorkingTool;
	
	public Robot() {
		this.identification = uniqueID++;
		this.workingHours = 0;
		this.currentWorkingTool = null;
	}
	
	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}
	
	public int getWorkingHours() {
		return workingHours;
	}
	
	public void setCurrentWorkingTool(Tool currentWorkingTool) {
		this.currentWorkingTool = currentWorkingTool;
	}
	
	public Tool getCurrentWorkingTool() {
		return currentWorkingTool;
	}
}
