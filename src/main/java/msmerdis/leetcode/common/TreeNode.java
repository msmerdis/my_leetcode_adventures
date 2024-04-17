package msmerdis.leetcode.common;

import java.util.ArrayList;

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

	public Integer[] toArray() {
		ArrayList<Integer> list = new ArrayList<>();

		toArray (this, 0, list);

		return list.toArray(new Integer[list.size()]);
	}

	public static void toArray (TreeNode tree, int index, ArrayList<Integer> list) {
		while (list.size() <= index) {
			list.add(null);
		}
		list.set(index, tree.val);

		index <<= 1;

		if (tree.left != null) {
			toArray (tree.left, index + 1, list);
		}

		if (tree.right != null) {
			toArray (tree.right, index + 2, list);
		}
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
