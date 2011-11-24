public class PreorderTree<E extends Comparable<? super E>> extends SortedTree<E> {

	
	protected class PreorderIter implements TreeIter<E> {

		private StringBuilder path;
		private final Node<E> root;
		
		public PreorderIter(Node<E> root, String path) {
			this.root = root;
			if (path != null) {
				this.path = new StringBuilder(path);
			}
		}
		
		@Override
		public E next() {
			
			if (path == null) {
				path = new StringBuilder();
				return root.getData();
			}
			
			Node<E> next = null;
			Node<E> node = walkTo();
			
			if (node.getLeft() != null) {
				path.append('0');
				next = node.getLeft();
			} else if (node.getRight() != null) {
				path.append('1');
				next = node.getRight();
			}
			
			while (next == null && path.length() > 0) {
				node = node.getParent();
				char last = path.charAt(path.length() - 1);
				path.setLength(path.length() - 1);
				if (last != '1' && node.getRight() != null) {
					next = node.getRight();
					path.append('1');
				}
			}
			
			return next.getData();
		}
		
		protected Node<E> walkTo() {
			Node<E> node = root;
			for (int i = 0; i < path.length(); i++) {
				char c = path.charAt(i);
				if (c == '0') {
					node = node.getLeft();
				} else {
					node = node.getRight();
				}
			}
			
			return node;
		}

		@Override
		public E previous() {
			
			if (path == null) {
				return null;
			} else if (path.length() == 0) { //currently on the root node so we switch back to uninitialzed mode
				path = null;
				return null;
			}
			
			Node<E> prev = walkTo();
			
			path.setLength(path.length() - 1);
			
			return prev.getParent().getData();
		}

		@Override
		public boolean hasNext() {
			
			if (path == null) {
				return root != null;
			}
			
			Node<E> cur = walkTo();
			
			boolean hasNext = cur.getLeft() != null || cur.getRight() != null;
			
			if (!hasNext) {
				Node<E> next = null;
				StringBuilder tmp = new StringBuilder(path.toString());
				while (next == null && tmp.length() > 0) {
					cur = cur.getParent();
					char last = tmp.charAt(tmp.length() - 1);
					tmp.setLength(tmp.length() - 1);
					if (last != '1' && cur.getRight() != null) {
						next = cur.getRight();
					}
				}
				
				return next != null;
			}
			
			return hasNext;
		}

		@Override
		public boolean hasPrevious() {
			Node<E> prev = walkTo();
			return prev.getParent() != null;
		}

		@Override
		public TreeIter<E> down() {
			Node<E> cur = walkTo();
			
			return new PreorderIter(cur, null);
		}
		
	}

	@Override
	public TreeIter<E> iterator(Node<E> e) {
		return new PreorderIter(e, null);
	}
}
