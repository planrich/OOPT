
class StringNode extends Node {
	
	private String label;
	
	public StringNode(String label) {
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
		if (obj == this) {
			return true;
		}
		if (obj instanceof StringNode) {
			StringNode node = (StringNode) obj;
			return label.equals(node.getLabel());
		}
		return false;
	}
}
