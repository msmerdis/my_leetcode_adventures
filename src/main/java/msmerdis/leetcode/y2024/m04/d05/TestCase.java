package msmerdis.leetcode.y2024.m04.d05;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private String word;
	private String great;

	public TestCase (String word, String great) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.word = word;
		this.great = great;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getWord() {
		return word;
	}

	public String getGreat() {
		return great;
	}

}
