package msmerdis.leetcode;

import java.util.Arrays;
import java.util.List;

public interface SolutionRunner {

	public int getId();
	public String getName ();
	public List<SolutionTestCase> testCases ();
	public boolean invoke (SolutionTestCase testCase);

	public default boolean compareAnyOrder (int[][] actual, int[][] expected) {
		if (expected.length != actual.length) {
			return false;
		}

		for (int i = 0; i < actual.length; i += 1) {
			int j;
			for (j = 0; j < expected.length; j += 1) {
				if (Arrays.equals(actual[i], expected[j])) {
					break;
				}
			}
			if (j >= expected.length) {
				return false;
			}
		}
		return true;
	}
}
