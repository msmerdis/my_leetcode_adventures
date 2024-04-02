package msmerdis.leetcode.y2024.m04.d01;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private String input;
	private int length;

	public TestCase (String input, int length) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.input = input;
		this.length = length;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getInput() {
		return input;
	}

	public int getLength() {
		return length;
	}

}
