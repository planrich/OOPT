
public class ReplaceableTree extends Replaceable implements StringTree {
	
	@Override
	public boolean contains(String node) {
		
		if (root == null) {
			return false;
		}
		
		return root.contains(node);
	}

	@Override
	public String search(String node) {
		
		if (!contains(node)) {
			return Node.NOT_FOUND;
		}
		
		StringBuilder builder = new StringBuilder();
		depthSearch(root, node, builder);
		
		String reverted = revertWords(builder.toString().trim());

		return reverted;
	}
	
	@Override
	public String toString() {
		return root.toString();
	}
	
	@Override
	public void add(String node) {
		replaceable_add(node);
	}
	
	@Override
	public Node getFor(String label) {
		return new StringNode(label);
	}

	@Override
	protected boolean equals(Node n, String label) {
		if (n instanceof StringNode) {
			return label.equals(label);
		}
		
		return false;
	}
}
