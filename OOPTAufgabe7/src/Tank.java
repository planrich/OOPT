
public abstract class Tank extends Section {

	@Override
	public boolean loadTo(Transporter transporter) {
		return transporter.load(this);
	}
	
	@Override
	public boolean unloadFrom(Transporter transporter) {
		return transporter.unload(this);
	}
}
