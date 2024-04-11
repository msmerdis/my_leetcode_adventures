package msmerdis.leetcode.y2024.m04.d11;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private int digits;
	private String num;
	private String res;

	public TestCase (String num, int k, String res) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.num = num;
		this.res = res;
		this.digits = k;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getNum() {
		return num;
	}

	public String getRes() {
		return res;
	}

	public int getDigits() {
		return digits;
	}

}
