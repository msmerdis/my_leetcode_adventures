package msmerdis.leetcode.common;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
		
	}

	public TreeNode(int val) {
		this.val = val;
	}
	
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static TreeNode of (Integer[] tree) {
		return of (tree, 0);
	}

	private static TreeNode of (Integer[] tree, int r) {
		if (r >= tree.length || tree[r] == null) {
			return null;
		}
		return new TreeNode(tree[r], of(tree, (r << 1) + 1), of(tree, (r << 1) + 2));
	}
}
