
public class TestPostorderTree extends TestSortedTree {

	@Override
	protected SortedTree<Integer> getTreeImpl() {
		return new PostorderTree<Integer>();
	}


}
