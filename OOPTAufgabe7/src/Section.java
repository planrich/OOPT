
public abstract class Section {
	
	protected Animal animal = null;
	
	public abstract boolean loadMamba(Mamba mamba);
	public abstract boolean loadPython(Python python);
	public abstract boolean loadBigTurtle(BigTurtle turtle);
	public abstract boolean loadSmallTurtle(SmallTurtle turtle);
	
	public abstract boolean loadDolphin(Dolphin dolphin);
	public abstract boolean loadSwordfish(Swordfish swordfish);
	public abstract boolean loadSeal(Seal seal);
	
	public abstract Mamba unloadMamba();
	public abstract Python unloadPython();
	public abstract BigTurtle unloadBigTurtle();
	public abstract SmallTurtle unloadSmallTurtle();
	
	public abstract Dolphin unloadDolphin();
	public abstract Swordfish unloadSwordfish();
	public abstract Seal unloadSeal();
	
	public Animal unload() {
		Animal a = this.animal;
		this.animal = null;
		return a;
	}
}
