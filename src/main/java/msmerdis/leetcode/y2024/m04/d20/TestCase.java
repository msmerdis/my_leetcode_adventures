package msmerdis.leetcode.y2024.m04.d20;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private int[][] land;
	private int[][] groups;

	public TestCase (String[] matrix, String[] groups) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.land   = toIntMatrix(matrix);
		this.groups = toIntMatrix(groups);
	}

	@Override
	public int getId() {
		return id;
	}

	public int[][] getLand() {
		return land;
	}

	public int[][] getGroups() {
		return groups;
	}

}
