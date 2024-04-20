package msmerdis.leetcode;

public interface SolutionTestCase {

	public int getId ();

	public default char[][] toCharMatrix (String[] data) {
		char[][] matrix = new char[data.length][];

		for (int i = 0; i < data.length; i += 1) {
			matrix[i] = data[i].toCharArray();
		}

		return matrix;
	}

	public default int[][] toIntMatrix (String[] data) {
		int[][] matrix = new int[data.length][];

		for (int i = 0; i < data.length; i += 1) {
			matrix[i] = new int[data[i].length()];
			for (int j = 0; j < data[i].length(); j += 1) {
				matrix[i][j] = data[i].charAt(j) - '0';
			}
		}

		return matrix;
	}
}
