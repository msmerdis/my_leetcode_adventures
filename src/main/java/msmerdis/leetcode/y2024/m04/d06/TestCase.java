package msmerdis.leetcode.y2024.m04.d06;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private String word;
	private int length;

	public TestCase (String word, int length) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.word = word;
		this.length = length;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getWord() {
		return word;
	}

	public int getLength() {
		return length;
	}

}
