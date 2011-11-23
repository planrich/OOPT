
public class IntTree extends Replaceable {

	public boolean contains(int node) {
		
		if (root == null) {
			return false;
		}
		
		return root.contains(Integer.toString(node));
	}

	public String search(int node) {
		
		if (!contains(node)) {
			return Node.NOT_FOUND;
		}
		
		StringBuilder builder = new StringBuilder();
		depthSearch(root, Integer.toString(node), builder);
		
		String reverted = revertWords(builder.toString().trim());

		return reverted;
	}
	
	@Override
	public String toString() {
		return root.toString();
	}
	
	public void add(int node) {
		replaceable_add(Integer.toString(node));
	}
	

	@Override
	protected Node getFor(String label) {
		
		Integer it = Integer.parseInt(label);
		return new IntNode(it);
	}

	@Override
	protected boolean equals(Node node, String label) {

		if (node instanceof IntNode) {
			Integer it = Integer.parseInt(label);
			it.equals(node.getLabel());
		}

		return false;
	}
	
}
