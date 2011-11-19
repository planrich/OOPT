
public abstract class SortedTree implements StringTree {

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
			root = new Node(node);
			return;
		}
		
		insert(root, node);
	}
	
	public String traverse() {
		StringBuilder builder = new StringBuilder();
		traverse(builder, root);
		return builder.toString();
	}
	
	protected abstract void traverse(StringBuilder buffer, Node node);
	
	private void insert(Node node, String key) {
		int comp = key.compareTo(node.getLabel());
		if (comp < 0) {
			if (node.getLeft() == null) {
				Node n = new Node(key);
				node.setLeft(n);
				return;
			} else {
				insert(node.getLeft(), key);
			}
		} else {
			if (node.getRight() == null) {
				Node n = new Node(key);
				node.setRight(n);
				return;
			} else {
				insert(node.getRight(), key);
			}
		}
	}
	
	@Override
	public String toString() {
		return root.toString();
	}
}
