
public class Test {

	public static void main(String[] args) {
		SortedTree tree = new PreorderTree();
		
		tree.add("d");
		tree.add("b");
		tree.add("a");
		tree.add("c");
		tree.add("f");
		tree.add("g");
		tree.add("e");
		
		System.out.println(tree);
		
		System.out.println(tree.traverse());
	}

}
