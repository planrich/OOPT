
public interface StringTree {

	static final String NODE_NOT_FOUND = "Knoten wurde nicht gefunden.";
	static final String NODE_LEFT = "left";
	static final String NODE_RIGHT = "right";
	
	boolean contains(String node); // node not null
	String search(String node); // node not null
	void add(String node); // node not null
}
