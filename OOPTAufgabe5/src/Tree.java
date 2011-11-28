public abstract class Tree<E> {

	protected Node<E> root = null;

	/**
	 * contains sucht ein Element im Baum und gibt einen Iterator vom Typ
	 * TreeIter<...> zurück, der über dem gefundenen Element und den Elementen
	 * des enstprechenden Teilbaums iteriert. Enthält der Baum das gesuchte
	 * Element nicht, soll null zurückgegeben werden.
	 * 
	 * @param data
	 * @return
	 */
	public TreeIter<E> contains(E data) {
		return contains(root, data);
	}

	private TreeIter<E> contains(Node<E> from, E data) {

		if (from != null) {
			
			//MUST NOT be null see node impl
			/*if(from.getData() == null) { //added this temporarily
				return null; 
			}*/
			if (from.getData().equals(data)) {
				return iterator(from);
			}

			TreeIter<E> it = contains(from.getLeft(), data);
			if (it == null) {
				it = contains(from.getRight(), data);
			}
			
			return it;
		}

		return null;
	}

	public TreeIter<E> iterator() {
		return iterator(root);
	}

	protected List<Node<E>> makeTraverseList(Node<E> root) {
		List<Node<E>> list = new List<Node<E>>();
		traverse(list, root);
		return list;
	}
	
	protected abstract void traverse(List<Node<E>> list, Node<E> root);
	
	public abstract TreeIter<E> iterator(Node<E> e);

	public Iter<Boolean> search(E data) {		
		StringBuilder path = new StringBuilder();
		boolean found = depthSearch(root, data, path);
		
		if (found) {
			return new BoolIter(path.reverse().toString());
		}

		return null;
	}
	
	protected boolean depthSearch(Node<E> node, E data, StringBuilder path) {
		
		if (node != null) {
			
			//MUST NOT be null see Node impl
			/*if(node.getData() == null) { //added that temporarily
				return false;
			}*/
			
			if (node.getData().equals(data)) {
				return true;
			}
			
			boolean back = depthSearch(node.getLeft(), data, path);
			if (back) {
				path.append("0");
				return true;
			}
			back = depthSearch(node.getRight(), data, path);
			if (back) {
				path.append("1");
				return true;
			}
		}
		
		return false;
	}

	public abstract void add(E data);

	protected class BoolIter implements Iter<Boolean> {

		String path;
		int pos;
		
		public BoolIter(String path) {
			pos = 0;
			this.path = path;
		}
		
		@Override
		public Boolean next() {
			if (pos >= path.length()) {
				return false;
			}
			
			return path.charAt(pos++) == '0' ? false : true;
		}

		@Override
		public Boolean previous() {
			if ((pos-1) < 0) {
				return false;
			}
			
			return path.charAt(--pos) == '0' ? false : true;
		}

		@Override
		public boolean hasNext() {
			return pos < path.length();
		}

		@Override
		public boolean hasPrevious() {
			return pos > 0;
		}
	}

}
