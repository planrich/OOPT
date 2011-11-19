
public class ReplaceableTree implements StringTree {

	protected StringNode root = null;
	protected int level = 0;
	protected int insertPostion = 0;
	
	@Override
	public boolean contains(String node) {
		
		if (root == null) {
			return false;
		}
		
		return root.contains(node);
	}

	@Override
	public String search(String node) {

		return null;
	}
	
	public void replace(String position, String subTree) { //subTree must not be null
		
		if (subTree == null) {
			throw new IllegalArgumentException("subTree must not be null");
		}
		
		if (root == null && position == "") {
			StringNode replacement = StringNode.parseTree(subTree);
			root = replacement; //maybe still null
			return;
		} else if (root == null) {
			return;
		}
		
		Node n = root.findNode(position);
		if (n != null) {
			
			String last = StringNode.nextDirection(position, true);
			boolean left = last.equals(StringNode.LEFT) ? true : false;

			StringNode replacement = StringNode.parseTree(subTree);
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
	
	@Override
	public void add(String node) {
		if (root == null) {
			root = new StringNode(node);
			insertPostion = 1;
			level = 1;
		} else {
			insertPostion++;		
			
			int start_ele = (int)Math.pow(2, level);
			int code = insertPostion - start_ele;
			
			String binary = convertToBinary(code,level);
			
			//System.out.println("insert " + insertPostion + " at level " + level + " with code " + code + " = " + binary);
			
			boolean success = insert(root, node, binary);

			updateLevels();	
			
			//it is possible to insert a not replaceable tree, so there might already be a node at that postion.
			//therefore we make it recursive until we inserted it all
			if (!success) {
				add(node);
			}
		}
	}

	private String convertToBinary(int code, int digits) {

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

	/**
	 * Update the level! This is necessary to call after every add call.
	 */
	private void updateLevels() {
		if(insertPostion == (Math.pow(2, level + 1) - 1)) {
			level++;
		}
	}
	
	/**
	 * Inserts at the position given by the binary search string.
	 * @param node
	 * @param label
	 * @param binary
	 * @return true iff binary position is empty, false otherwise
	 */
	private boolean insert(Node node, String label, String binary) {
		
		if (node == null) {
			return false;
		}
		
		if (binary.length() == 1) {
			//insert
			if (binary.charAt(0) == '0') {
				if (node.getLeft() == null) {
					node.setLeft(new StringNode(label));
					return true;
				} else {
					return false;
				}
			} else {
				if (node.getRight() == null) {
					node.setRight(new StringNode(label));
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
}
