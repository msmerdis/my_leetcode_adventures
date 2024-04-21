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

	public default void exec () {
		for (SolutionTestCase tc : testCases()) {
			String status;
			try {
				status = invoke(tc) ? "success" : "failure";
			} catch (Exception e) {
				status = e.getClass().getSimpleName() + ": " + e.getMessage();
				e.printStackTrace();
			}
			System.out.println(String.format("Test case %d : %s", tc.getId(), status));
		}
	}
}
