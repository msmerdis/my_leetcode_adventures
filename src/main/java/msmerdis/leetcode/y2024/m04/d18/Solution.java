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

		int[] prev = new int[0];

		for (int i = 0; i < grid.length; i += 1) {
			p += islandPerimeter (prev, grid[i]);
			p += islandPerimeter (grid[i]);
			prev = grid[i];
		}
		p += islandPerimeter (prev, new int[0]);
		return p;
	}

	// calculate the coastal boarders between two rows
	// if both neighbors are either island or sea
	// then no boarder is found
	//
	// in case one array is less than the other
	// the island tiles in the larger array
	// will be considered a boarder
	private int islandPerimeter(int[] x, int[] y) {
		int p = 0;
		int i;
		for (i = 0; i < x.length && i < y.length; i += 1) {
			if ((x[i] == 0 && y[i] > 0) || (x[i] > 0 && y[i] == 0)) {
				p += 1;
			}
		}
		while (i < x.length) {
			if (x[i] > 0) {
				p += 1;
			}
			i += 1;
		}
		while (i < y.length) {
			if (y[i] > 0) {
				p += 1;
			}
			i += 1;
		}
		return p;
	}

	// calculate the coastal boarders in a row
	// Similarly to the boarder between rows
	// if both neighbors are either island or sea
	// then no boarder is found
	private int islandPerimeter(int[] r) {
		int p = 0;
		int i;
		int prev = 0;

		for (i = 0; i < r.length; i += 1) {
			if ((prev == 0 && r[i] > 0) || (prev > 0 && r[i] == 0)) {
				p += 1;
			}
			prev = r[i];
		}

		if (prev > 0) {
			p += 1;
		}
		return p;
	}
}
