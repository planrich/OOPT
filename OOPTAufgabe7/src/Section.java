
public abstract class Section { //Abteil

	protected Animal animal;
	protected boolean isFree;
	
	public void printAnimal() {
		if(animal != null) {
			System.out.println(animal.getName());
		}
	}
}
