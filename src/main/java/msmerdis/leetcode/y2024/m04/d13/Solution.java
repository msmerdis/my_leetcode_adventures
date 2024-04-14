package msmerdis.leetcode.y2024.m04.d13;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 85;
	}

	@Override
	public String getName() {
		return "Maximal Rectangle";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new String[] {
				"10100",
				"10111",
				"11111",
				"10010"
			}, 6),
			new TestCase (new String[] {
				"1111",
				"1111",
				"1111",
				"1111"
			}, 16),
			new TestCase (new String[] {
				"0110111111111111110",
				"1011111111111111111",
				"1101111111110111111",
				"1111111111111011111",
				"1111111111111101111",
				"1110111011111111101",
				"1011111111111101111",
				"1111111111111110110",
				"0011111111111110111",
				"1101111111011111111",
				"1111111110111111111",
				"0110111011111111111",
				"1111011111111101111",
				"1111111111111111111",
				"1111111111111111111",
				"1111111111111111101",
				"1111111101101101111",
				"1111110111111110111"
			}, 51),
			new TestCase (new String[] {"0"}, 0),
			new TestCase (new String[] {"1"}, 1),
			new TestCase (new String[] {
				"0011",
				"1011",
				"1011",
				"1011"
			}, 8),
			new TestCase (new String[] {
				"0111",
				"0000",
				"1111",
				"1111"
			}, 8)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			int area = maximalRectangle (((TestCase)testCase).getMatrix());
			return area == ((TestCase)testCase).getArea();
		}
		return false;
	}

	public int maximalRectangle(char[][] matrix) {
		int max = 0;
		int[] row = new int[matrix[0].length];

		// process the matrix in rows and accumulate the
		// consecutive 1's into the row array
		//
		// then use maximalRectangle on the generated row
		// to calculate the area of the rectangles
		for (int r = 0; r < matrix.length; r += 1) {
			for (int c = 0; c < row.length; c += 1) {
				if (matrix[r][c] == '1') {
					row[c] += 1;
				} else {
					row[c] = 0;
				}
			}
			max = Math.max(max, maximalRectangle(row));
		}
		return max;
	}

	public int maximalRectangle(int[] row) {
		int max = 0;

		// parse the row twice
		// and try to match the greatest rectangle
		// for each start
		int h = 0;
		for (int c = 0; c < row.length; c += 1) {
			int j;
			
			// optimize by ignoring the second loop
			// in case a certain height has been processed
			// reset when zero height is reached
			if (h < row[c] && row[c] > 0) {
				h = row[c];
			} else {
				continue;
			}

			for (j = c + 1; h > 0 && j < row.length; j += 1) {
				if (h > row[j]) {
					max = Math.max(max, (j - c) * h);
					h = row[j];
				}
			}
			max = Math.max(max, (j - c) * h);
			h = row[c];
		}

		return max;
	}
}
