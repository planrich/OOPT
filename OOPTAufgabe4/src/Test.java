
public class Test {

	public static void main(String[] args) {
		InorderTree tree = new InorderTree();
		
		tree.add("c");
		tree.add("b");
		tree.add("e");
		tree.add("d");
		tree.add("f");
		
		System.out.println(tree);
		
		System.out.println(tree.search("d"));
	}

}
