
public class FactoryList extends List {
	
	/**
	 * Will search for a factory by the given name.
	 * @return Factory object or null.
	 */
	public Factory getByName(String name) {
		List.Iterator iter = this.iterator();
		
		while (iter.hasNext()) {
			Factory factory = (Factory) iter.next();
			if (factory.getName().equals(name)) {
				return factory;
			}
		}
		return null;
	}
}
