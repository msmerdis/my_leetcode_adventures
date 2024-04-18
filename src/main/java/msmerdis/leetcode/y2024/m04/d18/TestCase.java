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
		this.matrix = new int[matrix.length][];
		this.perimeter =  perimeter;
		
		for (int i = 0; i < matrix.length; i += 1) {
			this.matrix[i] = new int[matrix[i].length()];
			for (int j = 0; j < matrix[i].length(); j += 1) {
				this.matrix[i][j] = matrix[i].charAt(j) - '0';
			}
		}
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
