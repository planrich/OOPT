
public abstract class SortedTree implements StringTree {

	protected Node root = null;
	
	@Override
	public boolean contains(String node) {
		return contains(root, node);
	}

	@Override
	public String search(String node) {
		if (!contains(node)) {
			return NODE_NOT_FOUND;
		}
		
		StringBuilder builder = new StringBuilder();
		search(builder, root, node);
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
	
	private void search(StringBuilder buffer, Node node, String key) {
		if (node != null) {
			int comp = key.compareTo(node.getLabel());
			if (comp == 0) {
				return;
			} else if (comp < 0) {
				buffer.append(NODE_LEFT);
				buffer.append(" ");
				search(buffer, node.getLeft(), key);
			} else {
				buffer.append(NODE_RIGHT);
				buffer.append(" ");
				search(buffer, node.getRight(), key);
			}
		}
	}
	
	private boolean contains(Node node, String key) {
		if (node != null) {
			if (node.getLabel().equals(key)) {
				return true;
			}
			
			boolean contain = contains(node.getLeft(), key);
			if (!contain) {
				contain = contains(node.getRight(), key);
			}
			return contain;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return root.toString();
	}
}
