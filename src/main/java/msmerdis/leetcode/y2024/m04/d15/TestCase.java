package msmerdis.leetcode.y2024.m04.d15;

import msmerdis.leetcode.SolutionTestCase;
import msmerdis.leetcode.common.TreeNode;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private TreeNode tree;
	private int sum;

	public TestCase (Integer[] tree, int sum) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.tree = TreeNode.of(tree);
		this.sum  = sum;
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
