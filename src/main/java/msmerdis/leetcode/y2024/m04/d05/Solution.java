package msmerdis.leetcode.y2024.m04.d05;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 1544;
	}

	@Override
	public String getName() {
		return "Make The String Great";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase ("leEeetcode", "leetcode"),
			new TestCase ("abBAcC",     "")
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			return makeGood (((TestCase)testCase).getWord())
				.equals(((TestCase)testCase).getGreat());
		}
		return false;
	}

	private static int diff = 'A' - 'a';

	public String makeGood (String s) {
		char[] ch = s.toCharArray();
		int i;
		int j;

		for (i = 0, j = 1; j < ch.length; j += 1) {
			if (i >= 0 && (
				ch[i] + diff == ch[j] ||
				ch[i] - diff == ch[j]
			)) {
				i -= 1;
			} else {
				i += 1;
				ch[i] = ch[j];
			}
		}
		return String.copyValueOf(ch, 0, i+1);
	}
}
