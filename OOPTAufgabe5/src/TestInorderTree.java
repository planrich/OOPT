
public class TestInorderTree extends TestSortedTree {

	@Override
	protected SortedTree<Integer> getTreeImpl() {
		return new InorderTree<Integer>();
	}


}
