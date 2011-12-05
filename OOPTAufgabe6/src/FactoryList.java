
public class FactoryList extends List<Factory> {
	
	/*
	 * returning null when no Factory with given name is found
	 */
	public Factory getByName(String name) {
		List.Iterator<Factory> fact_iter = this.iterator();
		
		while (fact_iter.hasNext()) {
			Factory factory = fact_iter.next();
			if(factory.getName() == name) {
				return factory;
			}
		}
		return null;
	}
}
