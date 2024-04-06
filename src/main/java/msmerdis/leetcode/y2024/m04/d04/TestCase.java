package msmerdis.leetcode.y2024.m04.d04;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private String expression;
	private int depth;

	public TestCase (String expression, int depth) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.expression = expression;
		this.depth = depth;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getExpression() {
		return expression;
	}

	public int getDepth() {
		return depth;
	}

}
