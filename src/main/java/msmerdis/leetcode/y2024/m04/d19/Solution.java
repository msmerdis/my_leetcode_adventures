package msmerdis.leetcode.y2024.m04.d19;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 200;
	}

	@Override
	public String getName() {
		return "Number of Islands";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new String[] {
				"11110",
				"11010",
				"11000",
				"00000"
			}, 1),
			new TestCase (new String[] {
				"11000",
				"11000",
				"00100",
				"00011"
			}, 3)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			int islands = numIslands (((TestCase)testCase).getMatrix());
			return islands == ((TestCase)testCase).getIslands();
		}
		return false;
	}

	public int numIslands(char[][] grid) {
		int c = 0;
		for (int i = 0; i < grid.length; i += 1) {
			for (int j = 0; j < grid[i].length; j += 1) {
				c += removeIsland(grid, i, j);
			}
		}
		return c;
	}

	public int removeIsland (char[][] grid, int i, int j) {
		// if i,j is out of bounds for the grid return 0
		if (i < 0 || j < 0) {
			return 0;
		}
		if (i >= grid.length) {
			return 0;
		}
		if (j >= grid[i].length) {
			return 0;
		}

		// if tile is not an island also return 0;
		if (grid[i][j] == '0') {
			return 0;
		}

		// remove the island
		grid[i][j] = '0';

		// Recursively remove the connected island tiles
		removeIsland (grid, i+1, j);
		removeIsland (grid, i-1, j);
		removeIsland (grid, i, j+1);
		removeIsland (grid, i, j-1);

		// finally return 1 if the island is removed
		return 1;
	}
}
