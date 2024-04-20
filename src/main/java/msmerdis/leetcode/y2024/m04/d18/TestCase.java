package msmerdis.leetcode.y2024.m04.d18;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private int[][] matrix;
	private int perimeter;

	public TestCase (String[] matrix, int perimeter) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.matrix = toIntMatrix(matrix);
		this.perimeter =  perimeter;
	}

	@Override
	public int getId() {
		return id;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public int getPerimeter() {
		return perimeter;
	}

}
