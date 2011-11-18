
public class ReplaceableTree implements StringTree {

<<<<<<< HEAD
	Node root = new Node("a");
	
	@Override
	public boolean contains(String node) {
		// TODO Auto-generated method stub
		return false;
=======
	protected Node root = null;
	protected int levels = 0;
	protected int numOfNodes = 0;
	
	@Override
	public boolean contains(String node) {
		return contains(root, node);
>>>>>>> FETCH_HEAD
	}

	@Override
	public String search(String node) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
=======
		
>>>>>>> FETCH_HEAD
		return null;
	}

	@Override
<<<<<<< HEAD
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
=======
	public String toString() {
		StringBuilder builder = new StringBuilder(); 
		print(builder, root, 0);
		return builder.toString();
	}
	
	@Override
	public void add(String node) {
		if (root == null) {
			root = new Node(node);
			numOfNodes = 1;
			levels = 1;
			return;
		}
		numOfNodes++;
		insert(root, node, 1);
	}
	
	private void updateLevels() {
		if(numOfNodes == (Math.pow(2, levels+1)-1)) {
			levels++;
		}
		System.out.println("Levels: " + levels + "Nodes: " +numOfNodes);
	}
	private boolean levelcheck() {
		if(numOfNodes-((Math.pow(2, levels-1))-1) == (Math.pow(2, levels))/2)
			return true;
		return false;
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
	
	public void replace(String position, String subTree) {
		
	}
	
	private void insert(Node node, String key, int currentLevel) {
		
		System.out.println("key: " + key + "   " + currentLevel + "   "+ levels);
		if(currentLevel == levels) {
			if (node.getLeft() == null) {
				Node n = new Node(key);
				node.setLeft(n);
				updateLevels();
				return;
			} else if (node.getRight() == null) {
				Node n = new Node(key);
				node.setRight(n);
				updateLevels();
				return;
			}
		} else {
			if (node.getLeft()!= null && levelcheck()) {
				insert(node.getLeft(), key, ++currentLevel);
			} else if (node.getRight()!=null) {
				insert(node.getRight(), key, ++currentLevel);
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
>>>>>>> FETCH_HEAD
	}
	
}
