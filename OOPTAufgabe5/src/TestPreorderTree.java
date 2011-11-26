
public class TestPreorderTree extends TestSortedTree {

	@Override
	protected SortedTree<Integer> getTreeImpl() {
		return new PreorderTree<Integer>();
	}


}
