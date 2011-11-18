
public class Node {

	private String label;
	private Node left;
	private Node right;
	
	public Node(String label) {
		this.label = label;
		left = null;
		right = null;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Node) {
			Node node = (Node) obj;
			return label.equals(node.getLabel());
		}
		return false;
	}
}
