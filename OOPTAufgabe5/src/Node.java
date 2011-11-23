
public class Node<E> {
	
	private E data;
	private Node<E> left;
	private Node<E> right;
	
	public Node(E data) {
		this.data = data;
	}
	
	public E getData() {
		return data;
	}

	public Node<E> getLeft() {
		return left;
	}

	public void setLeft(Node<E> left) {
		this.left = left;
	}

	public Node<E> getRight() {
		return right;
	}

	public void setRight(Node<E> right) {
		this.right = right;
	}
}
