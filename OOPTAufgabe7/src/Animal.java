
public abstract class Animal {
	private final String name;

	public String getName() {
		return name;
	}

	public Animal(String name) {
		this.name = name;
	}
	
	/**
	 * add this animal to the container
	 * @param container must not be null
	 * @return true if successful
	 */
	public abstract boolean load(Container container);
}
