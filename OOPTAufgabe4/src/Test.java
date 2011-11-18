
public class Test {

	public static void main(String[] args) {
		
		System.out.println("Making a new SortedTree (InorderTree)");
		SortedTree tree = new InorderTree();
		
		tree.add("d");
		System.out.println("Tree after inserting: 'd':");
		System.out.println(tree);
		
		tree.add("b");
		System.out.println("Tree after inserting: 'b':");
		System.out.println(tree);
		
		tree.add("a");
		System.out.println("Tree after inserting: 'a':");
		System.out.println(tree);
		
		tree.add("c");
		System.out.println("Tree after inserting: 'c':");
		System.out.println(tree);
		
		tree.add("f");
		System.out.println("Tree after inserting: 'f':");
		System.out.println(tree);
		
		tree.add("g");
		System.out.println("Tree after inserting: 'g':");
		System.out.println(tree);
		
		tree.add("e");
		System.out.println("Tree after inserting: 'e':");
		System.out.println(tree);
		
		System.out.println("Does the tree contain 'g'? " + tree.contains("g"));
		System.out.println("Does the tree contain 'h'? " + tree.contains("h"));
		System.out.println();
		System.out.println("Searching for 'c': " + tree.search("c"));
		System.out.println("Searching for 'f': " + tree.search("f"));
		System.out.println("Searching fof 'g': " + tree.search("g"));
		System.out.println();
		System.out.println("Traversing this tree (InOrder): " + tree.traverse());
		System.out.println();
		
		System.out.println("Making a new PreorderTree with the same nodes ...");
		tree = new PreorderTree();
		tree.add("d");
		tree.add("b");
		tree.add("a");
		tree.add("c");
		tree.add("f");
		tree.add("g");
		tree.add("e");
		System.out.println("Traversing the PreorderTree: " + tree.traverse());
		System.out.println();
		
		System.out.println("Making a new PostorderTree with the same nodes ...");
		tree = new PostorderTree();
		tree.add("d");
		tree.add("b");
		tree.add("a");
		tree.add("c");
		tree.add("f");
		tree.add("g");
		tree.add("e");
		System.out.println("Traversing the PostorderTree: " + tree.traverse());
		
		ReplaceableTree rTree = new ReplaceableTree();
		rTree.add("c");
		rTree.add("d");
		rTree.add("e");
		rTree.add("f");
		rTree.add("g");
		rTree.add("h");
		rTree.add("i");
		rTree.add("j");
		
		System.out.println("Replaceable Tree: \n" + rTree);
		
		System.out.println();
		
		System.out.println("ReplacementTree: (preserving empyt nodes)");
		ReplaceableTree t = new ReplaceableTree();
		t.root.setLeft(new Node("x"));
		t.root.getLeft().setRight(new Node("y"));
		t.root.getLeft().getRight().setLeft(new Node("z"));
		System.out.println(t.root.toStringPreserveEmpty());
		System.out.println("replacing left right left with new tree:");
		t.replace("left right left", "a\n- b\n - c\n - d\n- e\n");
		System.out.println(t.root.toStringPreserveEmpty());
		System.out.println();
	}
}
