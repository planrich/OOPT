
public abstract class Section { //Abteil

	protected Animal animal;
	protected boolean isFree;
	
	public void printAnimal() { // Just temporary! We probably remove this when finished
		if(animal != null) {
			System.out.println(animal.getName());
		}
	}
}
