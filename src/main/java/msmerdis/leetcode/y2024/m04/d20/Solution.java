package msmerdis.leetcode.y2024.m04.d20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 1992;
	}

	@Override
	public String getName() {
		return "Find All Groups of Farmland";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new String[] {
				"100",
				"011",
				"011"
			}, new String[] {
				"0000",
				"1122"
			}),
			new TestCase (new String[] {
				"110",
				"111",
				"001"
			}, new String[] {
				"0011",
				"1222"
			}),
			new TestCase (new String[] {
				"11",
				"11"
			}, new String[] {
				"0011"
			}),
			new TestCase (new String[] {
				"0"
			}, new String[] {
			})
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			int[][] groups = findFarmland (((TestCase)testCase).getLand());
			return compareAnyOrder(groups, ((TestCase)testCase).getGroups());
		}
		return false;
	}

	public int[][] findFarmland(int[][] land) {
		List<int[]> groups = new LinkedList<>();
		List<Integer> diff = new ArrayList<>(land.length);
		int i;
		int j;
		int val;
		int idx;

		for (i = 0; i < land.length; i += 1) {
			val = 0;
			idx = 0;

			for (j = 0; j < land[i].length; j += 1) {
				if (diff.size() <= j) {
					diff.add(j, land[i][j] > 0 ? 1 : 0);
				} else {
					int curr = diff.get(j);
					int next = land[i][j] > 0 ? curr + 1 : 0;

					// if group terminates
					if (val > 0 && val != curr) {
						groups.add(new int[] {i-val,idx,i-1,j-1});
						val = 0;
					}

					if (val == 0 && curr > 0 && next == 0) {
						val = curr;
						idx = j;
					}

					diff.set(j, next);
				}
			}

			// in case the group terminates to a wall
			if (val > 0) {
				groups.add(new int[] {i-val,idx,i-1,j-1});
			}
		}

		// in case the group terminates to the last row
		val = 0;
		idx = 0;

		for (j = 0; j < diff.size(); j += 1) {
			int curr = diff.get(j);

			// if group terminates
			if (val > 0 && val != curr) {
				groups.add(new int[] {i-val,idx,i-1,j-1});
				val = 0;
			}

			if (val == 0 && curr > 0) {
				val = curr;
				idx = j;
			}
		}

		// in case the group terminates to a wall
		if (val > 0) {
			groups.add(new int[] {i-val,idx,i-1,j-1});
		}

		// extract groups as array
		return groups.toArray(new int[groups.size()][]);
	}

}
