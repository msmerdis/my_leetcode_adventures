package msmerdis.leetcode.y2024.m04.d24;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private int num;
	private int val;

	public TestCase (int num, int val) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.num = num;
		this.val = val;
	}

	@Override
	public int getId() {
		return id;
	}

	public int getNum() {
		return num;
	}

	public int getVal() {
		return val;
	}

}
