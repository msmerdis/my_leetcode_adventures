package msmerdis.leetcode.y2024.m04.d06;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 1249;
	}

	@Override
	public String getName() {
		return "Minimum Remove to Make Valid Parentheses";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase ("lee(t(c)o)de)", 12),
			new TestCase ("a)b(c)d",        6),
			new TestCase ("))((",           0),
			new TestCase ("(a(b(c)d)",      8)
		);
	}

	private boolean isBalanced (String s) {
		char[] cs = s.toCharArray();
		int cnt = 0;

		for (int i = 0; i < cs.length; i += 1) {
			switch (cs[i]) {
			case '(': cnt += 1; break;
			case ')': cnt -= 1;
				if (cnt < 0) {
					return false;
				}
			}
		}

		return cnt == 0;
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			String valid = minRemoveToMakeValid (((TestCase)testCase).getWord());
			return isBalanced(valid) && valid.length() == ((TestCase)testCase).getLength();
		}
		return false;
	}

	public String minRemoveToMakeValid (String s) {
		char[] cs = s.toCharArray();
		int cnt = 0;
		int i;
		int j;

		// traverse the array forward and remove all unbalanced ) symbols
		// i.e. ending a new parenthesis before starting one
		//
		// this cannot be fixed without having this character removed
		for (i = 0, j = 0; j < cs.length; j += 1) {
			switch (cs[j]) {
			case ')':
				if (cnt > 0) {
					cnt -= 1;
					cs[i] = cs[j];
					i += 1;
				}
				break;
			case '(': cnt += 1;
			default :
				cs[i] = cs[j];
				i += 1;
			}
		}

		// traverse the array backwards starting from the end
		// of the updated string (having the ')' symbols removed
		// and look back the last cnt '(' symbols to remove
		// as those symbols do not have a corresponding ending
		for (j = i, i -= cnt; cnt > 0;) {
			j -= 1;
			if (cs[j] == '(') {
				cnt -= 1;
			}
		}

		// remove the unbalanced '(' symbols
		for (int k = j; k < i; j += 1) {
			if (cs[j] != '(') {
				cs[k] = cs[j];
				k += 1;
			}
		}

		return new String(cs, 0, i);
	}
}
