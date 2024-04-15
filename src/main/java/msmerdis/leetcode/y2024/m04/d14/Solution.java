package msmerdis.leetcode.y2024.m04.d14;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;
import msmerdis.leetcode.common.TreeNode;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 404;
	}

	@Override
	public String getName() {
		return "Sum of Left Leaves";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new Integer[] {3,9,20,null,null,15,7}, 24),
			new TestCase (new Integer[] {1}, 0)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			int sum = sumOfLeftLeaves (((TestCase)testCase).getTree());
			return sum == ((TestCase)testCase).getSum();
		}
		return false;
	}

	public int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeaves(root, false);
	}

	public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return isLeft ? root.val : 0;
		}
		return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
	}
}
