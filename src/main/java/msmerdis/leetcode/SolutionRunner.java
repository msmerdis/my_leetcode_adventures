package msmerdis.leetcode;

import java.util.List;

public interface SolutionRunner {

	public int getId();
	public String getName ();
	public List<SolutionTestCase> testCases ();
	public boolean invoke (SolutionTestCase testCase);
}
