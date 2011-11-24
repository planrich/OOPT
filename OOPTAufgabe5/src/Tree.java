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

	public abstract TreeIter<E> iterator(Node<E> e);

	public Iter<Boolean> search(E data) {
		TreeIter<E> it = contains(data); //going back previous will not always lead to search goal!
		if (it == null) {
			return null;
		}
		
		StringBuilder builder = new StringBuilder();
		depthSearch(root, data, builder);

		return new BoolIter(builder.reverse().toString());
	}
	
	protected boolean depthSearch(Node<E> node, E data, StringBuilder builder) {
		
		if (node != null) {
			
			if (node.getData().equals(data)) {
				return true;
			}
			
			boolean back = depthSearch(node.getLeft(), data, builder);
			if (back) {
				builder.append("0");
				return true;
			}
			back = depthSearch(node.getRight(), data, builder);
			if (back) {
				builder.append("1");
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
			return path.charAt(pos++) == '0' ? false : true;
		}

		@Override
		public Boolean previous() {
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
