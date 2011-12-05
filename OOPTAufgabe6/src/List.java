
public class List {

	private ListElement headElement = null;
	private ListElement tailElement = null;
	
	public void add(Object element) {
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
	
	public void remove(Object element) {
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
	
	
	public interface Iterator {
		Object next();
		Object previous();
		boolean hasNext();
		boolean hasPrevious();
	}
	
	public Iterator iterator() {
		return new ListIter(headElement);
	}
	
	private class ListIter implements Iterator {

		private ListElement next;
		private ListElement previous;
		private ListElement current;
		
		public ListIter(ListElement head) {
			next = head;
			current = null;
			previous = null;
		}
		
		@Override
		public Object next() {
			if (next == null) {
				return null;
			}
			current = next;
			next = next.getNext();
			previous = current.getPrevious();
			return current.getElement();
		}

		@Override
		public Object previous() {
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
		
		private Object element;
		private ListElement next;
		private ListElement previous;
		
		public ListElement(Object element) {
			this.element = element;
			this.next = null;
			this.previous = null;
		}
		
		public Object getElement() {
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
