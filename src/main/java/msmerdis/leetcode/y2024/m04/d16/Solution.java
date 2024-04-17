package msmerdis.leetcode.y2024.m04.d16;

import java.util.Arrays;
import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;
import msmerdis.leetcode.common.TreeNode;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 623;
	}

	@Override
	public String getName() {
		return "Add One Row to Tree";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new Integer[] {2},  1, 1, new Integer[] {1, 2}),
			new TestCase (new Integer[] {4, 2, 6, 3, 1, 5}, 1, 2, new Integer[] {4, 1, 1, 2, null, null, 6, 3, 1, null, null, null, null, 5}),
			new TestCase (new Integer[] {4, 2, null, 3, 1}, 1, 3, new Integer[] {4, 2, null, 1, 1, null, null, 3, null, null, 1})
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			Integer[] tree = addOneRow (((TestCase)testCase).getTree(), ((TestCase)testCase).getValue(), ((TestCase)testCase).getDepth()).toArray();
			return Arrays.equals(tree, ((TestCase)testCase).getResult());
		}
		return false;
	}

	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (depth < 1) {
			return root;
		}
		if (depth == 1) {
			return new TreeNode(val, root, null);
		}

		appendOneRow (root, val, depth);
		return root;
	}

	private void appendOneRow (TreeNode root, int val, int depth) {
		if (root == null) {
			return;
		}
		if (depth <= 2) {
			root.left  = new TreeNode(val, root.left, null);
			root.right = new TreeNode(val, null, root.right);
		} else {
			appendOneRow(root.left,  val, depth - 1);
			appendOneRow(root.right, val, depth - 1);
		}
	}
}
