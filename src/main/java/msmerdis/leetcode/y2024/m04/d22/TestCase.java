package msmerdis.leetcode.y2024.m04.d22;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private String[] deadends;
	private String target;
	private int steps;

	public TestCase (String[] deadends, String target, int steps) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.deadends = deadends;
		this.target = target;
		this.steps = steps;
	}

	@Override
	public int getId() {
		return id;
	}

	public String[] getDeadends() {
		return deadends;
	}

	public String getTarget() {
		return target;
	}

	public int getSteps() {
		return steps;
	}

}
