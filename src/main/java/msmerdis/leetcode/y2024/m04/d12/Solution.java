package msmerdis.leetcode.y2024.m04.d12;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 42;
	}

	@Override
	public String getName() {
		return "Trapping Rain Water";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new int[] {0,1,0,2,1,0,1,3,2,1,2,1}, 6),
			new TestCase (new int[] {4,2,0,3,2,5}, 9),
			new TestCase (new int[] {0,1,2,3,4,3,2,1,0}, 0)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			int volume = trap (((TestCase)testCase).getHeight());
			return volume == ((TestCase)testCase).getVolume();
		}
		return false;
	}

	public int trap(int[] height) {
		Map<Integer, Integer> last = new TreeMap<>();
		int c = 0;
		for (int i = 0; i < height.length; i += 1) {
			int p = 0;
			Iterator<Integer> keys = last.keySet().iterator();
			while (keys.hasNext()) {
				int h = keys.next();
				if (height[i] < h) {
					c += (height[i] - p) * (i - 1 - last.get(h));
					break;
				}
				c += (h - p) * (i - 1 - last.get(h));
				p = h;
				keys.remove();
			}
			last.put(height[i], i);
		}
		return c;
	}
}
