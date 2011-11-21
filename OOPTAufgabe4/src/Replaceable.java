
public abstract class Replaceable {
	
	Node root;
	protected int level = 0;
	protected int insertPostion = 0;
	
	public abstract Node getFor(String label);
	
	public void replace(String position, String subTree) {
		//if position, or subTree is malformed
		//there is no replacement
		
		level = 1;
		insertPostion = 1; // replacing can destroy balance so we start from the root again
		
		if (subTree == null || subTree.equals("")) {
			throw new IllegalArgumentException("subTree must not be null/empty");
		}		
		
		if (position == "") {
			root = parseTree(subTree); //can still be null
			return;
		} else if (root == null) { //illegal state to insert a path
			return;
		}
		
		Node n = root.findNode(position);
		if (n != null) {
			
			String last = Node.nextDirection(position, true);
			boolean left = last.equals(Node.LEFT) ? true : false;

			Node replacement = parseTree(subTree);
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
	
	/**
	 * Inserts at the position given by the binary search string.
	 * @param node
	 * @param label
	 * @param binary
	 * @return true iff binary position is empty, false otherwise
	 */
	protected boolean insert(Node node, String label, String binary) {
		
		if (node == null) {
			return false;
		}
		
		if (binary.length() == 1) {
			//insert
			if (binary.charAt(0) == '0') {
				if (node.getLeft() == null) {
					node.setLeft(getFor(label));
					return true;
				} else {
					return false;
				}
			} else {
				if (node.getRight() == null) {
					node.setRight(getFor(label));
					return true;
				} else {
					return false;
				}
			}
		} else {
			if (binary.charAt(0) == '0') {
				return insert(node.getLeft(), label, binary.substring(1));
			} else {
				return insert(node.getRight(), label, binary.substring(1));
			}
		}
		
	}	
	
	protected abstract boolean equals(Node n, String label);
	
	protected boolean depthSearch(Node n, String label, StringBuilder builder) {
		
		if (n != null) {
			
			if (n.getLabel().equals(label)) {
				return true;
			}
			
			boolean back = depthSearch(n.getLeft(), label, builder);
			if (back) {
				builder.append(Node.LEFT + " ");
				return true;
			}
			back = depthSearch(n.getRight(), label, builder);
			if (back) {
				builder.append(Node.RIGHT + " ");
				return true;
			}
		}
		
		return false;
	}
	
	protected void replaceable_add(String label) {
		if (root == null) {
			root = getFor(label);
			insertPostion = 1;
			level = 1;
		} else {
			insertPostion++;		
			
			int start_ele = (int)Math.pow(2, level);
			int code = insertPostion - start_ele;
			
			String binary = convertToBinary(code,level);
			
			//System.out.println("insert " + insertPostion + " at level " + level + " with code " + code + " = " + binary);
			
			boolean success = insert(root, label, binary);

			if(insertPostion == (Math.pow(2, level + 1) - 1)) { // update levels
				level++;
			}	
			
			//it is possible to insert a not replaceable tree, so there might already be a node at that postion.
			//therefore we make it recursive until we inserted
			if (!success) {
				replaceable_add(label);
			}
		}
	}
	


	protected String convertToBinary(int code, int digits) {

		StringBuilder builder = new StringBuilder();
		while (code > 1) {
			builder.append(code % 2);
			code = code / 2;
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
	
	protected Node parseTree(String from) {
		int idx = from.indexOf('\n');
		if (idx == -1) {
			return null;
		}
		
		if (!from.startsWith("- ")) {
			throw new IllegalArgumentException();
		}
		
		String label = from.substring(2, idx);
		from = from.substring(idx + 1);
		
		Node root = getFor(label);
		
		parseChildren(root,from,1);
		
		return root;
	}	
	
	/**
	 * Parses the trees children. Utility function for parseTree.
	 * @param parent
	 * @param subTree
	 * @param level
	 * @return
	 */
	private String parseChildren(Node parent, String subTree, int level) {
		
		if (subTree.equals("")) {
			return subTree;
		}
		
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
			parent.setLeft(getFor(line));
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
			parent.setRight(getFor(line));
		}
		
		subTree = parseChildren(parent.getRight(), subTree, level + 1);
		
		return subTree;
	}
	
	protected String revertWords(String words) {
		StringBuilder builder = new StringBuilder(words.length());
		while (words.length() > 0) {
			int idx = words.lastIndexOf(' ');
			if (idx == -1) {
				break;
			}
			String step = words.substring(idx, words.length()).trim();
			builder.append(step + " ");
			words = words.substring(0,idx);
		}
		
		builder.append(words);
		
		return builder.toString();
	}
	
}
