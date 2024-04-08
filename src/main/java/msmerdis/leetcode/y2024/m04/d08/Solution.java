package msmerdis.leetcode.y2024.m04.d08;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 1700;
	}

	@Override
	public String getName() {
		return "Number of Students Unable to Eat Lunch";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new int[]{1,1,0,0}, new int[]{0,1,0,1}, 0),
			new TestCase (new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}, 3)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			int hungry = countStudents (((TestCase)testCase).getStudents(), ((TestCase)testCase).getSandwich());
			return hungry == ((TestCase)testCase).getHungry();
		}
		return false;
	}

	public int countStudents(int[] students, int[] sandwiches) {
		Map<Integer, Integer> freq = new HashMap<>();
		
		// order does not matter as students keep rotating until a sandwich is served
		// all that matters is if a student with the specific preference exist or not
		for (int s : students) {
			freq.compute(s, (key,val) -> val == null ? 1 : val + 1);
		}

		// serve the sandwiches
		for (int s : sandwiches) {
			int count = freq.getOrDefault(s, 0);
			// if a specific sandwich cannot be served
			// the rest of the students will stay hungry
			if (count == 0) {
				break;
			}
			freq.put(s, count - 1);
		}

		return freq.values().stream().reduce(0, (a,b) -> a + b);
	}
}
