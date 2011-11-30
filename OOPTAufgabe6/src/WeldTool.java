
public class WeldTool extends Tool {

	protected int meldTemperature;
	
	public WeldTool(int meldTemp) {
		this.meldTemperature = meldTemp;
	}
	
	
	public void setMeldTemperature(int meldTemperature) {
		this.meldTemperature = meldTemperature;
	}
	
	public int getMeldTemperature() {
		return meldTemperature;
	}
	
}
