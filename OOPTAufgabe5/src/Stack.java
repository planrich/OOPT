
public class Stack {

	private StackElement topElement;
	
	public void push(Node<?> node) {
		StackElement element = new StackElement(node);
		if (topElement != null) {
			element.setNext(topElement);
		}
		topElement = element;
	}
	
	public Node<?> pop() {
		if (topElement == null) {
			return null;
		}
		if (topElement.getNext() == null) {
			Node<?> node = topElement.getElement();
			topElement = null;
			return node;
		}
		Node<?> node = topElement.getElement();
		topElement = topElement.getNext();
		return node;
	}
	
	private class StackElement {
		
		private Node<?> element;
		private StackElement next;
		
		public StackElement(Node<?> element) {
			this.element = element;
			this.next = null;
		}
		
		public Node<?> getElement() {
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
