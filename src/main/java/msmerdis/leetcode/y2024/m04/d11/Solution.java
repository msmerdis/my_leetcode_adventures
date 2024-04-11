package msmerdis.leetcode.y2024.m04.d11;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 402;
	}

	@Override
	public String getName() {
		return "Remove K Digits";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase ("1432219", 3, "1219"),
			new TestCase ("10200", 1, "200"),
			new TestCase ("10", 2, "0"),
			new TestCase ("1000000000001", 1, "1"),
			new TestCase ("112", 1, "11"),
			new TestCase ("11111111111111112", 1, "1111111111111111"),
			new TestCase ("1000000000000000000", 1, "0"),
			new TestCase ("12345", 2, "123")
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			String res = removeKdigits (((TestCase)testCase).getNum(), ((TestCase)testCase).getDigits());
			return Objects.equals(res, ((TestCase)testCase).getRes());
		}
		return false;
	}

	public String removeKdigits(String num, int k) {
		// if all characters have to be removed
		// all that is left is 0
		if (k >= num.length()) {
			return "0";
		}
		// if no character will be removed
		// the num is going to remain the same
		if (k == 0) {
			return num;
		}
		List<Character> remover = new LinkedList<>();
		int i;
		for (i = 0; i < num.length() && k > 0; i += 1) {
			char ch = num.charAt(i);
			while (remover.size() > 0 && remover.getLast() > ch && k > 0) {
				remover.removeLast();
				k -= 1;
			}
			remover.addLast(ch);
		}

		// remove characters from the end of the list
		// until k digits have been removed
		while (k > 0) {
			remover.removeLast();
			k -= 1;
		}

		// collate all characters in the list and
		// combine with the rest of the substring
		StringBuffer res = new StringBuffer();
		remover.stream().forEach(res::append);
		res.append(num.substring(i));

		// remove leading zeros
		for (i = 0; i < res.length(); i += 1) {
			if (res.charAt(i) != '0') {
				return res.substring(i);
			}
		}

		// if string is only zeros, remove at least one
		return "0";
	}
}
