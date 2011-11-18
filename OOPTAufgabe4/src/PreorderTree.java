
public class PreorderTree extends SortedTree {
	
	@Override
	protected void traverse(StringBuilder buffer, Node node) {
		if (node != null) {
			buffer.append(node.getLabel());
			buffer.append(" ");
			
			traverse(buffer, node.getLeft());
			traverse(buffer, node.getRight());
		}
	}
}
