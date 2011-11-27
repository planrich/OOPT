
public class Node<E> {
	
	private E data;
	private Node<? extends E> left;
	private Node<E> right;
	private Node<E> parent;
	
	public Node(Node<E> parent, E data) { //data not null
		this.data = data;
		this.parent = parent;
	}
	
	public E getData() {
		return data;
	}
	
	public Node<E> getParent() {
		return parent;
	}

	public Node<? extends E> getLeft() {
		return left;
	}

	public void setLeft(Node<? extends E> left) {
		this.left = left;
	}

	public Node<E> getRight() {
		return right;
	}

	public void setRight(Node<E> right) {
		this.right = right;
	}
}
