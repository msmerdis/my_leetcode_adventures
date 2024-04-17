package msmerdis.leetcode.y2024.m04.d16;

import msmerdis.leetcode.SolutionTestCase;
import msmerdis.leetcode.common.TreeNode;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private TreeNode tree;
	private int value;
	private int depth;
	private Integer[] result;

	public TestCase (Integer[] tree, int value, int depth, Integer[] result) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.tree = TreeNode.of(tree);
		this.value = value;
		this.depth = depth;
		this.result = result;
	}

	@Override
	public int getId() {
		return id;
	}

	public TreeNode getTree() {
		return tree;
	}

	public int getValue() {
		return value;
	}

	public int getDepth() {
		return depth;
	}

	public Integer[] getResult() {
		return result;
	}

}
