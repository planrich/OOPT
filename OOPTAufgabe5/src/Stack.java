
public class Stack<E> {

	private StackElement topElement;
	
	public void push(Node<E> node) {
		StackElement element = new StackElement(node);
		if (topElement != null) {
			element.setNext(topElement);
		}
		topElement = element;
	}
	
	public Node<E> pop() {
		if (topElement == null) {
			return null;
		}
		if (topElement.getNext() == null) {
			Node<E> node = topElement.getElement();
			topElement = null;
			return node;
		}
		Node<E> node = topElement.getElement();
		topElement = topElement.getNext();
		return node;
	}
	
	public boolean hasNext() {
		if (topElement == null) {
			return false;
		}
		
		return topElement.getNext() != null;
	}
	
	public Node<E> current() {
		return topElement.getElement();
	}
	
	private class StackElement {
		
		private Node<E> element;
		private StackElement next;
		
		public StackElement(Node<E> element) {
			this.element = element;
			this.next = null;
		}
		
		public Node<E> getElement() {
			return element;
		}
		
		public StackElement getNext() {
			return next;
		}
		
		public void setNext(StackElement next) {
			this.next = next;
		}
	}
}
