
public class InorderTree extends SortedTree {

	@Override
	protected void traverse(StringBuilder buffer, Node node) {
		if (node != null) {
			traverse(buffer, node.getLeft());
			
			buffer.append(node.getLabel());
			buffer.append(" ");
			
			traverse(buffer, node.getRight());
		}
	}

}
