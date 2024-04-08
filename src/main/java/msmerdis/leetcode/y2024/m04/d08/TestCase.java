package msmerdis.leetcode.y2024.m04.d08;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private int[] students;
	private int[] sandwich;
	private int hungry;

	public TestCase (int[] students, int[] sandwich, int hungry) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.students = students;
		this.sandwich = sandwich;
		this.hungry = hungry;
	}

	@Override
	public int getId() {
		return id;
	}

	public int[] getStudents() {
		return students;
	}

	public int[] getSandwich() {
		return sandwich;
	}

	public int getHungry() {
		return hungry;
	}

}
