
public abstract class SortedTree<E extends Comparable<? super E>> extends Tree<E> {

	@Override
	public void add(E data) {
		if (root == null) {
			root = new Node<E>(null, data);
		} else {
			insert(root, data);
		}
	}
	
	private void insert(Node<E> node, E key) {		
		int comp = key.compareTo(node.getData());
		if (comp < 0) {
			if (node.getLeft() == null) {
				Node<E> n = new Node<E>(node,key);
				node.setLeft(n);
				return;
			} else {
				insert(node.getLeft(), key);
			}
		} else {
			if (node.getRight() == null) {
				Node<E> n = new Node<E>(node,key);
				node.setRight(n);
				return;
			} else {
				insert(node.getRight(), key);
			}
		}
	}

	@Override
	public Iter<Boolean> search(E data) {
		TreeIter<E> it = contains(data);
		if (it == null) {
			return null;
		}
		
		StringBuilder builder = new StringBuilder();
		search(builder, root, data);
		return new BoolIter(builder.toString());
	}
	
	private void search(StringBuilder buffer, Node<E> node, E key) {
		if (node != null) {
			int comp = key.compareTo(node.getData());
			if (comp == 0) {
				return;
			} else if (comp < 0) {
				buffer.append('0');
				search(buffer, node.getLeft(), key);
			} else {
				buffer.append('1');
				search(buffer, node.getRight(), key);
			}
		}
	}
}
