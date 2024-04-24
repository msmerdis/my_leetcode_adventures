package msmerdis.leetcode.y2024.m04.d24;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 1137;
	}

	@Override
	public String getName() {
		return "N-th Tribonacci Number";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (0, 0),
			new TestCase (1, 1),
			new TestCase (2, 1),
			new TestCase (3, 2),
			new TestCase (4, 4),
			new TestCase (5, 7),
			new TestCase (6, 13)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			int val = tribonacci (((TestCase)testCase).getNum());
			return val == ((TestCase)testCase).getVal();
		}
		return false;
	}

	public int tribonacci(int n) {
		int a = 0;
		int b = 1;
		int c = 1;
		int v;

		if (n <= 0) {
			return 0;
		}

		while (n > 2) {
			v = c + b + a;
			a = b;
			b = c;
			c = v;
			n = n - 1;
		}

		return c;
	}

}
