
class IntNode extends Node {

	private int label;
	
	public IntNode(int label) {
		this.label = label;
		left = null;
		right = null;
	}
	
	@Override
	public Object getLabel() {
		return label;
	}
	
	@Override
	public boolean equals(Object obj) {
		Integer origin = (Integer) label;
		if (obj == this) {
			return true;
		}
		if (obj instanceof IntNode) {
			IntNode node = (IntNode) obj;
			Integer compared = (Integer)(node.getLabel());
			return origin.equals(compared);
		}
		return false;
	}
}
