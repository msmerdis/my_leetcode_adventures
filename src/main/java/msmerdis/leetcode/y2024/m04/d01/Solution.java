package msmerdis.leetcode.y2024.m04.d01;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 58;
	}

	@Override
	public String getName() {
		return "Length of Last Word";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase ("hello world", 5),
			new TestCase ("  hello world  ", 5),
			new TestCase ("world", 5),
			new TestCase ("world   ", 5)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			return lengthOfLastWord (((TestCase)testCase).getInput()) == ((TestCase)testCase).getLength();
		}
		return false;
	}

	public int lengthOfLastWord (String s) {
		char[] arr = s.toCharArray();
		int i;
		int j;
		for (i = arr.length - 1; i >= 0 && arr[i] == ' '; i -= 1);
		for (j = i; j >= 0 && arr[j] != ' '; j -= 1);
		return i - j;
	}
}