
public abstract class Section { //Abteil

	protected Animal animal;
	protected boolean isFree = true;
	
	public Animal getAnimal() {
		return animal;
	}

	public abstract boolean loadTo(Transporter transporter);

	public abstract boolean unloadFrom(Transporter transporter);

	public boolean load(Animal a) {
		if (isFree) {
			return a.loadTo(this);
		}
		
		return false;
	}
	
	public Animal unload() {
		Animal a = this.animal;
		this.animal = null;
		if (a != null) {
			isFree = true;
		}
		
		return a;
	}
}
