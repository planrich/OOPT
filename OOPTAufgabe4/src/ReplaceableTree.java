
public class ReplaceableTree implements StringTree {

	protected Node root = null;
	protected int levels = 0;
	protected int numOfNodes = 0;
	
	@Override
	public boolean contains(String node) {
		return contains(root, node);
	}

	@Override
	public String search(String node) {
		// TODO Auto-generated method stub

		return null;
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
	
	@Override
	public void add(String node) {
		if (root == null) {
			root = new Node(node);
			numOfNodes = 1;
			levels = 1;
		} else {
			numOfNodes++;		
			
			
			int start_ele = (int)Math.pow(2, levels);
			int code = numOfNodes - start_ele;
			
			String binary = convertToBinary(code,levels);
			
			insert(root, node, binary);

			updateLevels();	
		}
	}

	
	
	private String convertToBinary(int code, int digits) {

		StringBuilder builder = new StringBuilder();
		while (code > 1) {
			builder.append(code % 2);
			code = code % 2;
		}
		
		if (code == 1) {

			builder.append(code % 2);
		}
		
		
		digits -= builder.length();
		
		while (digits > 0) {
			builder.append("0");
			digits -= 1;
		}
		
		return builder.reverse().toString();
	}

	private void updateLevels() {
		if(numOfNodes == (Math.pow(2, levels + 1) - 1)) {
			levels++;
		}
	}
	private boolean levelcheck() {
		if(numOfNodes-((Math.pow(2, levels-1))-1) == (Math.pow(2, levels))/2)
			return true;
		return false;
	}
	
	private void insert(Node node, String label, String binary) {
		
		if (binary.length() == 1) {
			//insert
			if (binary.charAt(0) == '0') {
				node.setLeft(new Node(label));
			} else {
				node.setRight(new Node(label));
			}
		} else {
			if (binary.charAt(0) == '0') {
				insert(node.getLeft(), label, binary.substring(1));
			} else {
				insert(node.getLeft(), label, binary.substring(1));
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
	
}
