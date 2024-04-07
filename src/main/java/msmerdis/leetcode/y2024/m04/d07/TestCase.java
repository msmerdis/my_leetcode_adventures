package msmerdis.leetcode.y2024.m04.d07;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private String word;
	private boolean valid;

	public TestCase (String word, boolean valid) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.word = word;
		this.valid = valid;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getWord() {
		return word;
	}

	public boolean isValid() {
		return valid;
	}

}
