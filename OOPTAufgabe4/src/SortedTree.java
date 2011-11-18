
public abstract class SortedTree implements StringTree {

	private Node root = null;
	
	@Override
	public boolean contains(String node) {
		return contains(root, node);
	}

	@Override
	public String search(String node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(String node) {
		if (root == null) {
			root = new Node(node);
			return;
		}
		
		insert(root, node);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(); 
		print(builder, root, 0);
		return builder.toString();
	}

	public abstract String traverse();
	
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
	
	private void print(StringBuilder buffer, Node node, int deep) {
		if (node != null) {
			for (int i = 0; i < deep; i++) {
				buffer.append("  ");
			}
			buffer.append("- ");
			buffer.append(node.getLabel());
			buffer.append('\n');
			
			print(buffer, node.getLeft(), deep + 1);
			print(buffer, node.getRight(), deep + 1);
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
}
