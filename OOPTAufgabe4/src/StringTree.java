
public interface StringTree {

	static final String NODE_NOT_FOUND = "Knoten wurde nicht gefunden.";
	static final String NODE_LEFT = "left";
	static final String NODE_RIGHT = "right";
	
	public boolean contains(String node); // node not null
	public String search(String node); // node not null
	public void add(String node); // node not null
}
