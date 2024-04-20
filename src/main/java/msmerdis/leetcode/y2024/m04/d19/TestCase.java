package msmerdis.leetcode.y2024.m04.d19;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private char[][] matrix;
	private int islands;

	public TestCase (String[] matrix, int islands) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.matrix = toCharMatrix(matrix);
		this.islands =  islands;
	}

	@Override
	public int getId() {
		return id;
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public int getIslands() {
		return islands;
	}

}
