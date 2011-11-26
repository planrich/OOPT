
public class PostorderTree<E extends Comparable<? super E>> extends SortedTree<E> {

	@Override
	public TreeIter<E> iterator(Node<E> root) {
		return new SortedIter(root);
	}

	@Override
	protected void traverse(List<Node<E>> list, Node<E> node) {
		if (node != null) {
			traverse(list, node.getLeft());
			traverse(list, node.getRight());
			
			list.append(node);
		}
	}
}
