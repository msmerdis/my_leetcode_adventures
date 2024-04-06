package msmerdis.leetcode.y2024.m04.d04;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 1614;
	}

	@Override
	public String getName() {
		return "Maximum Nesting Depth of the Parentheses";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase ("(1+(2*3)+((8)/4))+1", 3),
			new TestCase ("(1)+((2))+(((3)))"  , 3),
			new TestCase ("" , 0),
			new TestCase ("()" , 1),
			new TestCase ("()()" , 1),
			new TestCase ("()(()())" , 2)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			return maxDepth (((TestCase)testCase).getExpression()) ==
					((TestCase)testCase).getDepth();
		}
		return false;
	}

	public int maxDepth (String s) {
		char[] cs = s.toCharArray();
		int cnt = 0;
		int max = 0;

		for (int i = 0; i < cs.length; i += 1) {
			switch (cs[i]) {
			case ')': cnt -= 1; break;
			case '(': cnt += 1;
				if (max < cnt) {
					max = cnt;
				}
			}
		}
		
		return max;
	}
}
