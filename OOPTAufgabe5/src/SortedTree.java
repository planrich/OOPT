
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
	
	protected class SortedIter implements TreeIter<E> {
		
		private Iter<Node<E>> iterator;
		private Node<E> current;
		
		public SortedIter(Node<E> root) {
			List<Node<E>> list = new List<Node<E>>();
			iterator = list.iterator();
			current = root;
		}
		
		@Override
		public E next() {
			current = iterator.next();
			if (current == null) {
				return null;
			}
			return current.getData();
		}

		@Override
		public E previous() {
			current = iterator.previous();
			if (current == null) {
				return null;
			}
			return current.getData();
		}

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public boolean hasPrevious() {
			return iterator.hasPrevious();
		}

		@Override
		public TreeIter<E> down() {
			if (current == null) {
				return new EmptyIterator();
			}
			return new SortedIter(current);
		}
	}
	
	protected class EmptyIterator implements TreeIter<E> {

		@Override
		public E next() {
			return null;
		}

		@Override
		public E previous() {
			return null;
		}

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public boolean hasPrevious() {
			return false;
		}

		@Override
		public TreeIter<E> down() {
			return null;
		}
	}
}
