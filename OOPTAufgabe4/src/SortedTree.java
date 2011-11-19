
public abstract class SortedTree implements StringTree {
	
	//this tree can ONLY contain StringNode not other nodes.

	protected Node root = null;
	

	
	@Override
	public boolean contains(String node) {
		if (root != null) {
			return root.contains(node);
		}
		return false;
	}

	@Override
	public String search(String node) {
		if (!contains(node)) {
			return Node.NOT_FOUND;
		}
		
		StringBuilder builder = new StringBuilder();
		search(builder, root, node);
		return builder.toString();
	}
	

	
	private void search(StringBuilder buffer, Node node, String key) {
		if (node != null) {
			int comp = key.compareTo((String)node.getLabel());
			if (comp == 0) {
				return;
			} else if (comp < 0) {
				buffer.append(Node.LEFT);
				buffer.append(" ");
				search(buffer, node.getLeft(), key);
			} else {
				buffer.append(Node.RIGHT);
				buffer.append(" ");
				search(buffer, node.getRight(), key);
			}
		}
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
