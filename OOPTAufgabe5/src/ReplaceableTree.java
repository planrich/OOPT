
public class ReplaceableTree<E extends Comparable<? super E>> extends Tree<E> {

	private int level = 0;
	private int insertPostion = 0;
	
	private Node<E> getFor(E data) {
		Node<E> n = new Node<E>(root, data);
		return n;
	}
	
	@Override
	public void add(E data) {
		if (root == null) {
			root = getFor(data);
			insertPostion = 1;
			level = 1;
		} else {
			insertPostion++;		
			int start_ele = (int)Math.pow(2, level);
			int code = insertPostion - start_ele;
			
			String binary = convertToBinary(code,level);
			
			//System.out.println("insert " + insertPostion + " at level " + level + " with code " + code + " = " + binary);
			
			boolean success = insert(root, data, binary);
			
			if(insertPostion == (Math.pow(2, level + 1) - 1)) { // update levels
				level++;
			}	
			
			//it is possible to insert a not replaceable tree, so there might already be a node at that postion.
			//therefore we make it recursive until we inserted
			if (!success) {
				System.out.println(data + " could not be inserted");
				//add(data);
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
	
	protected boolean insert(Node<E> node, E label, String binary) {
		
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
	
	public void replace(Tree<? extends E> subTree, Iter<Boolean> position) {
		Tree<E> newTree = copyHelper(subTree);
		Node<E> pos = root;
		
		while(position.hasNext()) {
			Boolean next = position.next();
			if(next.booleanValue() == false) {
				if(position.hasNext() && pos.getLeft() != null) {
					pos = pos.getLeft();
				} else {
					pos.setLeft(newTree.root);
				}
			} else if(next.booleanValue()) {
				if(position.hasNext() && pos.getRight() != null) {
					pos = pos.getRight();
				} else {
					pos.setRight(newTree.root);
				}
			}
		}
	}
	

	private static <E extends Comparable<? super E>> Tree<E> copyHelper(Tree<? extends E> tree) {
		ReplaceableTree<E> rep = new ReplaceableTree<E>();
		rep.root = tree.root.clone();
		return rep;
	}
	
	 /*	private static <E extends Comparable<? super E>> Tree<E> copyHelper(Tree<? extends E> tree) {
		ReplaceableTree<E> rep = new ReplaceableTree<E>();
		TreeIter<? extends E> iter = tree.iterator();
		while(iter.hasNext()) {
			rep.add(iter.next());
		}
		return rep;
	}*/
	 
	
	@Override
	public TreeIter<E> iterator(Node<E> e) {
		return new RepIter(root); //preorder Iterator -> better for testing than inorder
	}
	
	protected void traverse(List<Node<E>> list, Node<E> node) {
		if (node != null) {
			list.append(node);
			traverse(list, node.getLeft());
			traverse(list, node.getRight());
		}
	}
	
	protected class RepIter implements TreeIter<E> {
		
		private Iter<Node<E>> iterator;
		private Node<E> current;
		
		public RepIter(Node<E> root) {
			List<Node<E>> list = makeTraverseList(root);
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
				return new RepIter(null);
			}
			return new RepIter(current);
		}
	}
}