
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

	@Override
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
	}
	
}
