
public abstract class Node {
	
	public static final String LEFT = "left";
	public static final String RIGHT = "right";
	public static final String NOT_FOUND = "Knoten wurde nicht gefunden.";
	
	/**
	 * "left right ..." returns left, "" return "", ...
	 * @param path
	 * @return an empty string, "left" or "right"
	 */
	public static String nextDirection(String path, boolean last) {
		
		int idx = 0;
		if (last) {
			idx = path.lastIndexOf(' ');
		} else {
			idx = path.indexOf(' ');
		}
		
		if (idx == -1) {
			return "";
		}
		
		if (last) {
			return path.substring(idx).trim();
		} else {
			return path.substring(0, idx);
		}
	}
	
	/**
	 * Parses a tree from a String
	 * @param from
	 * @return
	 */
	public static StringNode parseTree(String from) {
		
		int idx = from.indexOf('\n');
		if (idx == -1) {
			return null;
		}
		
		if (!from.startsWith("- ")) {
			throw new IllegalArgumentException();
		}
		
		String label = from.substring(2, idx);
		from = from.substring(idx + 1);
		
		StringNode node = new StringNode(label);
		
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
			parent.setLeft(new StringNode(line));
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
			parent.setRight(new StringNode(line));
		}
		
		return subTree;
	}
	
	protected Node left;
	protected Node right;
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(StringNode left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(StringNode right) {
		this.right = right;
	}
	
	public abstract Object getLabel();

	/**
	 * Returns true iff
	 * @param node
	 * @param key
	 * @param builder can be null
	 * @return return true iff the node with the key is in this node
	 */
	public boolean contains(String key) {
		
		if (getLabel().equals(key)) {
			return true;
		}
		
		boolean contain = false;
		
		if (left != null) {
			contain = left.contains(key);
		}
		
		if (!contain && right != null) {
			contain = right.contains(key);
		}
		
		return contain;
	}
	
	/**
	 * Find a node in the current node and follow the path given
	 * @param path
	 * @return null if there is no such path, a {@link StringNode} otherwise
	 */
	public Node findNode(String path) {
		
		String nextDir = nextDirection(path,false);
		
		if (nextDir.equals("")) {
			return this;
		} else {
			path = path.substring(nextDir.length(), path.length()).trim();
			
			if (nextDir.equals(StringNode.LEFT) && left != null) {
				return this.getLeft().findNode(path);
			} else if (right != null) {
				return this.getRight().findNode(path);
			} else {
				return null;
			}
		}
	}
	

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(); 
		print(builder, 0);
		return builder.toString();
	}
	
	/**
	 * Preserves the empty nodes in the output. with just "- \n"
	 * @return
	 */
	public String toStringPreserveEmpty() {
		StringBuilder builder = new StringBuilder(); 
		printPreserveEmpty(builder, 0);
		return builder.toString();
	}
	
	private void printPreserveEmpty(StringBuilder buffer, int deep) {

		for (int i = 0; i < deep; i++) {
			buffer.append("  ");
		}
		buffer.append("- ");
		buffer.append(getLabel());
		buffer.append('\n');
		
		if (left != null) {
			left.printPreserveEmpty(buffer, deep + 1);
		}
		
		if (right != null) {
			right.printPreserveEmpty(buffer, deep + 1);
		}
	}
	
	private void print(StringBuilder buffer, int deep) {

			for (int i = 0; i < deep; i++) {
				buffer.append("  ");
			}
			buffer.append("- ");
			buffer.append(getLabel());
			buffer.append('\n');
			
			if (left != null) {
				left.print(buffer, deep + 1);
			}
			
			if (right != null) {
				right.print(buffer, deep + 1);
			}
	}	
}
