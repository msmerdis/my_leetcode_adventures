package msmerdis.leetcode.y2024.m04.d12;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private int[] height;
	private int volume;

	public TestCase (int[] height, int volume) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.height = height;
		this.volume = volume;
	}

	@Override
	public int getId() {
		return id;
	}

	public int[] getHeight() {
		return height;
	}

	public int getVolume() {
		return volume;
	}

}
