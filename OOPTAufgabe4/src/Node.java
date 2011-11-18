
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(); 
		print(builder, this, 0);
		return builder.toString();
	}
	
	/**
	 * Preserves the empty nodes in the output. with just "- \n"
	 * @return
	 */
	public String toStringPreserveEmpty() {
		StringBuilder builder = new StringBuilder(); 
		printPreserveEmpty(builder, this, 0);
		return builder.toString();
	}
	
	private void printPreserveEmpty(StringBuilder buffer, Node node, int deep) {

		for (int i = 0; i < deep; i++) {
			buffer.append("  ");
		}
		buffer.append("- ");
		if (node != null) {
			buffer.append(node.getLabel());
		}
		buffer.append('\n');
		
		if (node != null) {
			print(buffer, node.getLeft(), deep + 1);
			print(buffer, node.getRight(), deep + 1);
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
	
	/**
	 * Parses a tree from a String
	 * @param from
	 * @return
	 */
	public static Node parseTree(String from) {
		
		int idx = from.indexOf('\n');
		if (idx == -1) {
			return null;
		}
		
		String label = from.substring(0, idx);
		from = from.substring(idx + 1);
		
		Node node = new Node(label);
		
		parseChildren(node,from,0);
		
		return node;
	}
	
	/**
	 * Parses the trees children. Utility function for parseTree
	 * @param parent
	 * @param subTree
	 * @param level
	 * @return
	 */
	private static String parseChildren(Node parent, String subTree, int level) {
		
		int idx = subTree.indexOf('\n');
		
		String line = subTree.substring(0,idx);
		
		for (int i = 0; i < level; i++) {
			if (subTree.charAt(i) != ' ') {
				return subTree;
			}
		}
		
		subTree = subTree.substring(idx + 1);

		line = line.substring(level);
		
		if (!line.startsWith("- ")) {
			throw new IllegalArgumentException("Malformed subTree");
		}
		
		line = line.substring(2);
		
		if (!line.equals("")) {	
			parent.setLeft(new Node(line));
		}
		
		subTree = parseChildren(parent.getLeft(), subTree, level + 1);
		
		idx = subTree.indexOf('\n'); //must be newline terminated
		
		line = subTree.substring(0,idx);
		
		for (int i = 0; i < level; i++) {
			if (subTree.charAt(i) != ' ') {
				return subTree;
			}
		}
		
		subTree = subTree.substring(idx + 1);
		line = line.substring(level);
		
		if (!line.startsWith("- ")) {
			throw new IllegalArgumentException("Malformed subTree");
		}
		
		line = line.substring(2);
		
		if (!line.equals("")) {	
			parent.setRight(new Node(line));
		}
		
		return subTree;
	}
}
