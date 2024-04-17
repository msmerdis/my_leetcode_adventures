package msmerdis.leetcode.y2024.m04.d17;

import msmerdis.leetcode.SolutionTestCase;
import msmerdis.leetcode.common.TreeNode;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private TreeNode tree;
	private String result;

	public TestCase (Integer[] tree, String result) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.tree = TreeNode.of(tree);
		this.result = result;
	}

	@Override
	public int getId() {
		return id;
	}

	public TreeNode getTree() {
		return tree;
	}

	public String getResult() {
		return result;
	}

}
