
public class PostorderTree extends SortedTree {

	@Override
	protected void traverse(StringBuilder buffer, Node node) {
		if (node != null) {
			traverse(buffer, node.getLeft());
			traverse(buffer, node.getRight());
			
			buffer.append(node.getLabel());
			buffer.append(" ");
		}
	}
}
