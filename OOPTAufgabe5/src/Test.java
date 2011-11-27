
public class Test {

	public static void main(String[] args) {
		
		System.out.print("creating test data...");
		
		ReplaceableTree<String> rep1 = new ReplaceableTree<String>();		
		rep1.add("Apfel");
		rep1.add("Birne");
		rep1.add("Erdbeere");
		rep1.add("Orange");
		rep1.add("Maracuja");
		
		InorderTree<Integer> inorder1 = new InorderTree<Integer>();
		inorder1.add(1);
		inorder1.add(2);
		inorder1.add(3);
		inorder1.add(4);
		inorder1.add(5);
		
		PreorderTree<Student> preorder1 = new PreorderTree<Student>();
		preorder1.add(new Student("Richard Plangger", 1025637));
		preorder1.add(new Student("Klaus Nigsh", 1025991));
		preorder1.add(new Student("Simon Zuend", 1025990));
		preorder1.add(new Student("Max Mustermann", 1010555));
	
		PostorderTree<Professor> postorder1 = new PostorderTree<Professor>();
		postorder1.add(new Professor("Krall", "complang"));
		postorder1.add(new Professor("Blieberger", "auto"));
		postorder1.add(new Professor("Raidl", "algodat"));
		postorder1.add(new Professor("Reiter", "complang"));
		
		System.out.println("done");
		System.out.println("ReplaceableTree<String>:");
		Iter<String> it1 = rep1.iterator();
		while (it1.hasNext()) {
			System.out.print(it1.next());
			if (it1.hasNext()) {
				System.out.println(", ");
			}
		}
		
		System.out.println("InorderTree<Integer>:");
		Iter<Integer> it2 = inorder1.iterator();
		while (it2.hasNext()) {
			System.out.print(it1.next());
			if (it2.hasNext()) {
				System.out.println(", ");
			}
		}

		System.out.println("PreorderTree<Student>:");
		Iter<Student> it3 = preorder1.iterator();
		while (it3.hasNext()) {
			Student cur = it3.next();
			System.out.print(String.format("%s %d", cur.getName(), cur.getMatrikelnummer()));
			if (it3.hasNext()) {
				System.out.println(", ");
			}
		}
		
		System.out.println("PostorderTree<Professor>:");
		Iter<Professor> it4 = postorder1.iterator();
		while (it4.hasNext()) {
			Professor cur = it4.next();
			System.out.print(String.format("%s %s",cur.getName(), cur.getInstitut()));
			if (it4.hasNext()) {
				System.out.println(", ");
			}
		}
		
		TreeIter<Student> contains1 = preorder1.contains(new Student("Max Mustermann",1010555));
		TreeIter<String> contains2 = rep1.contains("Zitrone");
		TreeIter<Integer> contains3 = inorder1.contains(4);
		
		Iter<Boolean> search1 = postorder1.search(new Professor("Krall", "complang"));
		Iter<Boolean> search2 = postorder1.search(new Professor("Kralli", "complang"));
		Iter<Boolean> search3 = rep1.search("Maracuja");
		
		System.out.println("PreorderTree contains MaxMustermann 1010555?");
		if (contains1 == null ) {
			System.out.println("not found");
		} else {
			System.out.println("yes, subtree:");
			while (contains1.hasNext()) {
				Student cur = contains1.next();
				System.out.println(String.format("%s %d",cur.getName(),cur.getMatrikelnummer()));
			}
		}
		
		System.out.println("ReplaceableTree contains 'Zitrone'?");
		if (contains2 == null ) {
			System.out.println("not found");
		} else {
			System.out.println("yes, subtree:");
			while (contains2.hasNext()) {
				System.out.println(contains2.next());
			}
		}
		
		System.out.println("InorderTree contains 4?");
		if (contains3 == null ) {
			System.out.println("not found");
		} else {
			System.out.println("yes, subtree:");
			while (contains3.hasNext()) {
				System.out.println(contains3.next());
			}
		}
		
		ReplaceableTree<Person> rep2 = new ReplaceableTree<Person>();
		rep2.add(new Student("Albert Einstein", 300300));
		rep2.add(new Student("Unnamed", 192838298));
		rep2.add(new Professor("Albert Einstein", "going for physics"));
		rep2.add(new Professor("Michael Reiter", "complang"));
		
		// TODO this printStructure is untested and i dont know jet if it is working correctly.
		// need to test it
		System.out.println("initial ReplaceableTree:");
		printStructure(rep2.iterator(), 0);
		
		
		String path = generatePath(search1);
		System.out.println("Searching for Krall/complang in PostorderTree! Path:");
		System.out.println(path);
		
		path = generatePath(search2);
		System.out.println("Searching for Kralli/complang in PostorderTree! Path:");
		System.out.println(path);
		
		path = generatePath(search3);
		System.out.println("Searching for Maracuja in ReplaceableTree! Path:");
		System.out.println(path);
		
		rep2.replace(preorder1, rep2.search(new Professor("Albert Einstein", "going for physics")));
		System.out.println("replaced prof. Albert Einstein with PreorderTree:");
		printStructure( rep2.iterator(), 0);
		
		rep2.replace(postorder1, rep2.search(new Professor("Michael Reiter", "complang")));
		System.out.println("replaced prof. Michael Reiter with PostOrderTree:");
		printStructure(rep2.iterator(), 0);
	}
	
	private static void printStructure(TreeIter<Person> it, int level) {

		while (it.hasNext()) {
			Person next = it.next();
			for (int i = 0; i < level; i++) {
				System.out.println("  ");
			}
			System.out.println("- " + next.getName());
			printStructure(it.down(), level + 1);
		}		
	}

	private static String generatePath(Iter<Boolean> it) {
		StringBuilder sb = new StringBuilder();

		while (it.hasNext()) {
			sb.append(it.next().toString() + " ");
		}
		
		return sb.toString().trim();
	}
	
}
