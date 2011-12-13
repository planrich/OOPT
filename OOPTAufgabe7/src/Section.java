
/**
 * Section class including loading of different animal types, as well as unloading them
 * Every load method must not contain a null parameter
 */
public abstract class Section {
	
	protected Animal animal = null;
	
	public abstract boolean loadMamba(Mamba mamba);
	public abstract boolean loadPython(Python python);
	public abstract boolean loadBigTurtle(BigTurtle turtle);
	public abstract boolean loadSmallTurtle(SmallTurtle turtle);
	
	public abstract boolean loadDolphin(Dolphin dolphin);
	public abstract boolean loadSwordfish(Swordfish swordfish);
	public abstract boolean loadSeal(Seal seal);
	
	public Animal unload() {
		Animal a = this.animal;
		this.animal = null;
		return a;
	}
	
	public Animal getAnimal() {
		return animal;
	}
}
