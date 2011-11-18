
public class ReplaceableTree implements StringTree {

	Node root = new Node("a");
	
	@Override
	public boolean contains(String node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String search(String node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(String node) {
		// TODO Auto-generated method stub

	}
	
	public void replace(String position, String subTree) { //subTree must not be null
		
		if (subTree == null) {
			throw new IllegalArgumentException("subTree must not be null");
		}
		
		Node n = findNodeIn(root,position);
		if (n != null) {
			
			String last = nextDirection(position, true);
			boolean left = last.equals(StringTree.NODE_LEFT) ? true : false;

			Node replacement = Node.parseTree(subTree);
			if (replacement == null) { //no replacement buildable
				return;
			}
			
			if (left) {
				n.setLeft(replacement);
			} else {
				n.setRight(replacement);
			}
		}
	}
	
	@Override
	public String toString() {
		return root.toString();
	}
	
	/**
	 * Find a node
	 * @param node
	 * @param path
	 * @param subTree
	 * @return
	 */
	private Node findNodeIn(Node node, String path ) {
		
		if (node == null) { //failed to find path
			return null;
		}
		
		String nextDir = nextDirection(path,false);
		
		if (nextDir.equals("")) {
			return node;
		} else {
			path = path.substring(nextDir.length(), path.length()).trim();
			
			if (nextDir.equals(SortedTree.NODE_LEFT)) {
				return findNodeIn(node.getLeft(),path);
			} else {
				return findNodeIn(node.getRight(),path);
			}
		}
	}
	
	/**
	 * "left right ..." returns left, "" return "", ...
	 * @param path
	 * @return an empty string, "left" or "right"
	 */
	private String nextDirection(String path, boolean last) {
		
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
	
}
