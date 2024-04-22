package msmerdis.leetcode.y2024.m04.d22;

import java.util.LinkedList;
import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 752;
	}

	@Override
	public String getName() {
		return "Open the Lock";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new String[] {
				"0201",
				"0101",
				"0102",
				"1212",
				"2002"
			}, "0202", 6),
			new TestCase (new String[] {
				"8888"
			}, "0009", 1),
			new TestCase (new String[] {
				"8888"
			}, "0090", 1),
			new TestCase (new String[] {
				"8888"
			}, "0900", 1),
			new TestCase (new String[] {
				"8888"
			}, "9000", 1),
			new TestCase (new String[] {
				"8887",
				"8889",
				"8878",
				"8898",
				"8788",
				"8988",
				"7888",
				"9888"
			}, "8888", -1),
			new TestCase (new String[] {
				"0000"
			}, "0009", -1)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			int steps = openLock (
				((TestCase)testCase).getDeadends(),
				((TestCase)testCase).getTarget()
			);
			return steps == ((TestCase)testCase).getSteps();
		}
		return false;
	}

	private static class Key {
		public int num1;
		public int num2;
		public int num3;
		public int num4;

		public Key () {
			num1 = 0;
			num2 = 0;
			num3 = 0;
			num4 = 0;
		}

		// convert a string to a key
		// no validation checks performed here
		public Key (String key) {
			num1 = key.charAt(0) - '0';
			num2 = key.charAt(1) - '0';
			num3 = key.charAt(2) - '0';
			num4 = key.charAt(3) - '0';
		}

		// create a custom key
		public Key (int num1, int num2, int num3, int num4) {
			this.num1 = num1;
			this.num2 = num2;
			this.num3 = num3;
			this.num4 = num4;
		}

		public void set (int[][][][] lut, int val) {
			lut[num1][num2][num3][num4] = val;
		}

		public int get (int[][][][] lut) {
			return lut[num1][num2][num3][num4];
		}

		private int normalize(int index) {
			if (index < 0) {
				return 9;
			}
			if (index > 9) {
				return 0;
			}
			return index;
		}

		// generate a list of all neighbours of the current key
		// this is a total of 8 neighbours
		public List<Key> neighbours () {
			List<Key> list = new LinkedList<>();

			list.add(new Key(normalize(num1+1), num2, num3, num4));
			list.add(new Key(normalize(num1-1), num2, num3, num4));
			list.add(new Key(num1, normalize(num2+1), num3, num4));
			list.add(new Key(num1, normalize(num2-1), num3, num4));
			list.add(new Key(num1, num2, normalize(num3+1), num4));
			list.add(new Key(num1, num2, normalize(num3-1), num4));
			list.add(new Key(num1, num2, num3, normalize(num4+1)));
			list.add(new Key(num1, num2, num3, normalize(num4-1)));

			return list;
		}
	}

	private final static int DEADEND = -1;
	private final static int TARGET = -2;

	public int openLock (String[] deadends, String target) {
		int[][][][] lut = new int[10][10][10][10];
		LinkedList<Key> queue = new LinkedList<>();

		// first encode all dead ends
		for (String deadend : deadends) {
			new Key(deadend).set(lut, DEADEND);
		}

		// then encode the target
		new Key(target).set(lut, TARGET);

		// start the the first location and mark it as 0
		Key start = new Key();
		queue.addLast(start);

		if (start.get(lut) == DEADEND) {
			return -1;
		}

		// for each item in the queue we check all neighbours
		// and step forward to the unvisited ones
		// dead end squares are skipped
		// target square is bringing the whole process to an end
		while (queue.size() > 0) {
			Key curr = queue.removeFirst();
			int step = curr.get(lut);

			for (Key neighbour : curr.neighbours()) {
				switch (neighbour.get(lut)) {
					case TARGET:
						return step + 1;
					case 0:
						neighbour.set(lut, step + 1);
						queue.addLast(neighbour);
					default:
						// do nothing
				}
			}
		}

		return -1;
	}

}
