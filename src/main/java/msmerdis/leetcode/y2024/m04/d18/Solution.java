package msmerdis.leetcode.y2024.m04.d18;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 463;
	}

	@Override
	public String getName() {
		return "Island Perimeter";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new String[] {
				"0000",
				"0110",
				"0100",
				"0000"
			}, 8),
			new TestCase (new String[] {
				"0110",
				"1001",
				"1001",
				"0110"
			}, 24),
			new TestCase (new String[] {
				"0110"
			}, 6),
			new TestCase (new String[] {
				"0",
				"1",
				"1",
				"0"
			}, 6),
			new TestCase (new String[] {
				"1001",
				"0000",
				"0000",
				"1001"
			}, 16),
			new TestCase (new String[] {
				"1001"
			}, 8),
			new TestCase (new String[] {
				"1",
				"0",
				"0",
				"1"
			}, 8),
			new TestCase (new String[] {
				"0100",
				"1110",
				"0100",
				"1100"
			}, 16),
			new TestCase (new String[] {"0"}, 0),
			new TestCase (new String[] {"1"}, 4),
			new TestCase (new String[] {"10"}, 4),
			new TestCase (new String[] {"01"}, 4),
			new TestCase (new String[] {"110"}, 6),
			new TestCase (new String[] {"011"}, 6),
			new TestCase (new String[] {
				"11",
				"10"
			}, 8),
			new TestCase (new String[] {
				"10",
				"11"
			}, 8),
			new TestCase (new String[] {
				"01",
				"11"
			}, 8),
			new TestCase (new String[] {
				"11",
				"01"
			}, 8)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			int perimeter = islandPerimeter (((TestCase)testCase).getMatrix());
			return perimeter == ((TestCase)testCase).getPerimeter();
		}
		return false;
	}

	public int islandPerimeter(int[][] grid) {
		int p = 0;
		int l = grid[0].length;

		if (grid.length == 0 || l == 0) {
			return 0;
		}

		for (int i = 1; i + 1 < grid.length; i += 1) {
			for (int j = 1; j + 1 < l; j += 1) {
				if (grid[i][j] > 0) {
					// check box above
					if (grid[i-1][j] == 0) p += 1;

					// check box below
					if (grid[i+1][j] == 0) p += 1;

					// check box on the left
					if (grid[i][j-1] == 0) p += 1;

					// check box on the right
					if (grid[i][j+1] == 0) p += 1;
				}
			}

			// check left column
			if (grid[i][0] > 0) {
				// check box above
				if (grid[i-1][0] == 0) p += 1;

				// check box below
				if (grid[i+1][0] == 0) p += 1;

				// check box on the left
				p += 1;

				// check box on the right
				if (l == 1 || grid[i][1] == 0) p += 1;
			}

			// check right column
			if (l > 1 && grid[i][l-1] > 0) {

				// check box above
				if (grid[i-1][l-1] == 0) p += 1;

				// check box below
				if (grid[i+1][l-1] == 0) p += 1;

				// check box on the left
				if (grid[i][l-2] == 0) p += 1;

				// check box on the right
				p += 1;
			}
		}

		for (int i = 1; i + 1 < l; i += 1) {
			// check top row
			if (grid[0][i] > 0) {
				// check box above
				p += 1;

				// check box below
				if (grid.length == 1 || grid[1][i] == 0) p += 1;

				// check box on the left
				if (grid[0][i-1] == 0) p += 1;

				// check box on the right
				if (grid[0][i+1] == 0) p += 1;
			}

			// check bottom row
			if (grid.length > 1 && grid[grid.length-1][i] > 0) {
				// check box above
				if (grid[grid.length-2][i] == 0) p += 1;

				// check box below
				p += 1;

				// check box on the left
				if (grid[grid.length-1][i-1] == 0) p += 1;

				// check box on the right
				if (grid[grid.length-1][i+1] == 0) p += 1;
			}
		}

		// check the four corners

		// top left
		if (grid[0][0] == 1) {
			// check box above
			p += 1;

			// check box below
			if (grid.length == 1 || grid[1][0] == 0) p += 1;

			// check box on the left
			p += 1;

			// check box on the right
			if (l == 1 || grid[0][1] == 0) p += 1;
		}

		// top right
		if (l > 1 && grid[0][l-1] == 1) {
			// check box above
			p += 1;

			// check box below
			if (grid.length == 1 || grid[1][l-1] == 0) p += 1;

			// check box on the left
			if (grid[0][l-2] == 0) p += 1;

			// check box on the right
			p += 1;
		}

		// bottom right
		if (grid.length > 1 && l > 1 && grid[grid.length-1][l-1] == 1) {
			// check box above
			if (grid[grid.length-2][l-1] == 0) p += 1;

			// check box below
			p += 1;

			// check box on the left
			if (grid[grid.length-1][l-2] == 0) p += 1;

			// check box on the right
			p += 1;
		}

		// bottom left
		if (grid.length > 1 && grid[grid.length-1][0] == 1) {
			// check box above
			if (grid[grid.length-2][0] == 0) p += 1;

			// check box below
			p += 1;

			// check box on the left
			p += 1;

			// check box on the right
			if (l == 1 || grid[grid.length-1][1] == 0) p += 1;
		}

		return p;
	}
}
