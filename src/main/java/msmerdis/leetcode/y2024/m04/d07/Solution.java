package msmerdis.leetcode.y2024.m04.d07;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 678;
	}

	@Override
	public String getName() {
		return "Valid Parenthesis String";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase ("()", true),
			new TestCase ("(*)", true),
			new TestCase ("(*))", true),
			new TestCase ("((*)", true),
			new TestCase ("(", false),
			new TestCase (")", false),
			new TestCase ("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())", false)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			boolean valid = checkValidString (((TestCase)testCase).getWord());
			return valid == ((TestCase)testCase).isValid();
		}
		return false;
	}

	public boolean checkValidString(String s) {
		char[] cs = s.toCharArray();
		int cnt = 0;
		int str = 0;
		int i;

		// traverse the string forward
		// and compensate for unbalanced ending characters
		// with a star character if possible
		for (i = 0; i < cs.length; i += 1) {
			switch (cs[i]) {
			case '*':
				str += 1;
				break;
			case '(':
				cnt += 1;
				break;
			case ')':
				if (cnt > 0) {
					cnt -= 1;
				} else {
					if (str <= 0) {
						return false;
					}
					str -= 1;
				}
				break;
			}
		}

		// if there are more unbalanced parenthesis
		// than left over stars we can end here
		if (cnt > str) {
			return false;
		}

		// look up the string backwards and attempt to do
		// the same for any opening parenthesis
		// there are no conflicts for the star characters
		// as if both an opening and and closing parenthesis
		// would compete for the same star character
		// those two parenthesis would match each other
		cnt = 0;
		str = 0;
		for (i = cs.length - 1; i >= 0; i -= 1) {
			switch (cs[i]) {
			case '*':
				str += 1;
				break;
			case ')':
				cnt += 1;
				break;
			case '(':
				if (cnt > 0) {
					cnt -= 1;
				} else {
					if (str <= 0) {
						return false;
					}
					str -= 1;
				}
				break;
			}
		}

		return true;
	}
}
