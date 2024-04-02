package msmerdis.leetcode.y2024.m04.d02;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private String s1;
	private String s2;
	private boolean isomorphic;

	public TestCase (String s1, String s2, boolean isomorphic) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.s1 = s1;
		this.s2 = s2;
		this.isomorphic = isomorphic;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getS1() {
		return s1;
	}

	public String getS2() {
		return s2;
	}

	public boolean isIsomorphic() {
		return isomorphic;
	}

}
