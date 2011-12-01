

public class List<E> {

	private ListElement headElement = null;
	private ListElement tailElement = null;
	
	public void add(E element) {
		ListElement e = new ListElement(element);
		if (headElement == null) {
			headElement = e;
			tailElement = e;
		} else {
			tailElement.setNext(e);
			e.setPrevious(tailElement);
			tailElement = e;
		}
	}
	
	public void remove(E element) {
		ListElement toDelete = headElement;
		while (toDelete != null && !toDelete.getElement().equals(element)) {
			toDelete = toDelete.next;
		}
		
		if (toDelete == null) {
			return;
		}
		
		ListElement previous = toDelete.previous;
		ListElement next = toDelete.next;
		
		if (previous != null) {
			previous.next = toDelete.next;
		} else {
			headElement = next;
		}
		
		if (next != null) {
			next.previous = previous;
		} else {
			tailElement = previous;
		}
	}
	
	public Iterator<E> iterator() {
		return new ListIter(headElement);
	}
	
	public interface Iterator<E> {
		E next();
		E previous();
		boolean hasNext();
		boolean hasPrevious();
	}
	
	private class ListIter implements Iterator<E> {

		private ListElement next;
		private ListElement previous;
		private ListElement current;
		
		public ListIter(ListElement head) {
			next = head;
			current = null;
			previous = null;
		}
		
		@Override
		public E next() {
			if (next == null) {
				return null;
			}
			current = next;
			next = next.getNext();
			previous = current.getPrevious();
			return current.getElement();
		}

		@Override
		public E previous() {
			if (previous == null) {
				return null;
			}
			current = previous;
			next = current.getNext();
			previous = current.getPrevious();
			return current.getElement();
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public boolean hasPrevious() {
			return previous != null;
		}
	}
	
	private class ListElement {
		
		private E element;
		private ListElement next;
		private ListElement previous;
		
		public ListElement(E element) {
			this.element = element;
			this.next = null;
			this.previous = null;
		}
		
		public E getElement() {
			return element;
		}
		
		public ListElement getNext() {
			return next;
		}
		
		public void setNext(ListElement next) {
			this.next = next;
		}

		public ListElement getPrevious() {
			return previous;
		}

		public void setPrevious(ListElement previous) {
			this.previous = previous;
		}
	}
}
