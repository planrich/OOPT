
public class Hitch {
	
	private Trailer trailer;
	
	/**
	 * Connects the trailer to this hitch.
	 * @param trailer The trailer. Must not be null.
	 * @return true if successful
	 */
	public boolean loadTrailer(Trailer trailer) {
		if (this.trailer == null) {
			this.trailer = trailer;
			return true;
		}
		return false;
	}
	
	public Trailer unload() {
		Trailer trail = this.trailer;
		this.trailer = null;
		return trail;
	}
	
	public Trailer getTrailer() {
		return trailer;
	}
}
