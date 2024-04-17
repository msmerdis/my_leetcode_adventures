package msmerdis.leetcode.y2024.m04.d17;

import java.util.List;
import java.util.Objects;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;
import msmerdis.leetcode.common.TreeNode;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 988;
	}

	@Override
	public String getName() {
		return "Smallest String Starting From Leaf";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new Integer[] { 0,1,2,3,4,3,4}, "dba"),
			new TestCase (new Integer[] {25,1,3,1,3,0,2}, "adz"),
			new TestCase (new Integer[] {2,2,1,null,1,0,null,null,null,0}, "abc"),
			new TestCase (new Integer[] {4,0,1,1}, "bae"),
			new TestCase (new Integer[] {25,1,null,0,0,null,null,1,null,null,null,null,null,null,null,0}, "ababz")
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			String least = smallestFromLeaf (((TestCase)testCase).getTree());
			return Objects.equals(least, ((TestCase)testCase).getResult());
		}
		return false;
	}

	// start with an empty postfix
	// and keep accumulating the value of the node
	// going towards the leafs
	// and compare generated words
	// to keep the smallest one on the way up
	public String smallestFromLeaf(TreeNode root) {
		return smallestFromLeaf (root, "");
	}

	public String smallestFromLeaf(TreeNode root, String postfix) {
		// for the empty case we just return the post fix value
		// this is going to cover the case where we have an empty tree
		// as well returning the empty string that is provided at the start
		// of the recursion
		if (root == null) {
			return postfix;
		}

		// append the letter of the current node to the start of the postfix string
		postfix = Character.toString(root.val + 'a') + postfix;

		// in case any of the two nodes is null
		// we can avoid the string comparison
		// this is also covering the case of leaf nodes
		// by supplying a null to the next recursive call
		// that is just going to return the postfix value
		if (root.left == null) {
			return smallestFromLeaf(root.right, postfix);
		}
		if (root.right == null) {
			return smallestFromLeaf(root.left, postfix);
		}

		// for nodes that have both left and right
		// trees we have to compare the two string
		// to keep the smallest one
		String l = smallestFromLeaf(root.left,  postfix);
		String r = smallestFromLeaf(root.right, postfix);

		int ll = l.length();
		int rl = r.length();
		int len = Math.min(ll,rl);

		for (int i = 0; i < len; i += 1) {
			char lc = l.charAt(i);
			char rc = r.charAt(i);

			if (lc < rc) {return l;}
			if (lc > rc) {return r;}
			
		}

		if (ll < rl) {return l;}
		return r;
	}
}
