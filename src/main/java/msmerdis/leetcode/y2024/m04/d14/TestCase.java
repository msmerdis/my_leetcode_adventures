package msmerdis.leetcode.y2024.m04.d14;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private TreeNode tree;
	private int sum;

	public TestCase (Integer[] tree, int sum) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.tree = buildTree(tree, 0);
		this.sum  = sum;
	}

	private TreeNode buildTree (Integer[] tree, int r) {
		if (r >= tree.length || tree[r] == null) {
			return null;
		}
		return new TreeNode(tree[r], buildTree(tree, (r << 1) + 1), buildTree(tree, (r << 1) + 2));
	}

	@Override
	public int getId() {
		return id;
	}

	public TreeNode getTree() {
		return tree;
	}

	public int getSum() {
		return sum;
	}

}
