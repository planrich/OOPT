
public abstract class Tree<E> {
	
	protected Node<E> root = null;
	
	public TreeIter<E> contains(E data) {
		return null;
	}
	
	public TreeIter<E> iterator() {
		return null;
	}
	
	public Iter<Boolean> search(E data) {
		return null;
	}
	
	public abstract void add(E data);
}
