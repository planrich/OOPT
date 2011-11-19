
public abstract class SortedTree implements StringTree {
	
	//this tree can ONLY contain StringNode not other nodes.

	protected Node root = null;
	
	@Override
	public boolean contains(String node) {
		if (root == null) {
			return false;
		}
		
		return root.contains(node, null);
	}

	@Override
	public String search(String node) {

		if (root == null) {
			return Node.NOT_FOUND;
		}
		
		StringBuilder builder = new StringBuilder();
		if (!root.contains(node, builder)) {
			return Node.NOT_FOUND;
		}
		
		return builder.toString();
	}

	@Override
	public void add(String node) {
		if (root == null) {
			root = new StringNode(node);
			return;
		}
		
		if (root instanceof StringNode) {
			insert((StringNode)root, node);
		}
	}
	
	public String traverse() {
		StringBuilder builder = new StringBuilder();
		traverse(builder, root);
		return builder.toString();
	}
	
	protected abstract void traverse(StringBuilder buffer, Node node);
	
	private void insert(StringNode node, String key) {		
		
		int comp = key.compareTo((String)node.getLabel());
		if (comp < 0) {
			if (node.getLeft() == null) {
				StringNode n = new StringNode(key);
				node.setLeft(n);
				return;
			} else {
				insert((StringNode)node.getLeft(), key);
			}
		} else {
			if (node.getRight() == null) {
				StringNode n = new StringNode(key);
				node.setRight(n);
				return;
			} else {
				insert((StringNode)node.getRight(), key);
			}
		}
	}
	
	@Override
	public String toString() {
		return root.toString();
	}
}
