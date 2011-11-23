
public interface Iter<E> {
	E next();
	E previous();
	boolean hasNext();
	boolean hasPrevious();
}
