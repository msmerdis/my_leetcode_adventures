package msmerdis.leetcode.y2024.m04.d02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 205;
	}

	@Override
	public String getName() {
		return "Isomorphic Strings";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase ("egg", "add", true),
			new TestCase ("foo", "bar", false),
			new TestCase ("paper", "title", true)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			return isIsomorphic (((TestCase)testCase).getS1(), ((TestCase)testCase).getS2()) ==
					((TestCase)testCase).isIsomorphic();
		}
		return false;
	}

	public boolean isIsomorphic (String s, String t) {
		char[] sca = s.toCharArray();
		char[] tca = t.toCharArray();

		Map<Character, Character> map = new HashMap<>();
		Set<Character> mapped = new HashSet<>();

		int i = Math.min(sca.length, tca.length) - 1;

		while (i >= 0) {
			if(!map.containsKey(sca[i])) {
				if (mapped.contains(tca[i])) {
					return false;
				}
				map.put(sca[i], tca[i]);
				mapped.add(tca[i]);
			}
			if (map.get(sca[i]).charValue() != tca[i]) {
				return false;
			}
			i -= 1;
		}
		
		return true;
	}
}
