package msmerdis.leetcode.y2024.m04.d15;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;
import msmerdis.leetcode.common.TreeNode;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 129;
	}

	@Override
	public String getName() {
		return "Sum Root to Leaf Numbers";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new Integer[] {1,2,3}, 25),
			new TestCase (new Integer[] {1}, 1),
			new TestCase (new Integer[] {1,2,null,3}, 123),
			new TestCase (new Integer[] {4,9,0,5,1}, 1026),
			new TestCase (new Integer[] {}, 0)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			int sum = sumNumbers (((TestCase)testCase).getTree());
			return sum == ((TestCase)testCase).getSum();
		}
		return false;
	}

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return sumNumbers(root, 0);
	}

	public int sumNumbers(TreeNode root, int num) {
		num *= 10;
		num += root.val;

		if (root.left == null && root.right == null) {
			return num;
		}
		if (root.left == null ) {
			return sumNumbers(root.right, num);
		}
		if (root.right == null) {
			return sumNumbers(root.left, num);
		}
		return sumNumbers(root.right, num) + sumNumbers(root.left, num);
	}
}
