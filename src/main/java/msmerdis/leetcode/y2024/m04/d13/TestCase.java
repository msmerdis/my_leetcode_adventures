package msmerdis.leetcode.y2024.m04.d13;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private char[][] matrix;
	private int area;

	public TestCase (String[] matrix, int area) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.matrix = new char[matrix.length][];
		this.area =  area;
		
		for (int i = 0; i < matrix.length; i += 1) {
			this.matrix[i] = matrix[i].toCharArray();
		}
	}

	@Override
	public int getId() {
		return id;
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public int getArea() {
		return area;
	}

}
