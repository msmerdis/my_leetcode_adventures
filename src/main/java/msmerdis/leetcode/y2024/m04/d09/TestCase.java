package msmerdis.leetcode.y2024.m04.d09;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private int[] tickets;
	private int k;
	private int time;

	public TestCase (int[] tickets, int k, int time) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.tickets = tickets;
		this.k = k;
		this.time = time;
	}

	@Override
	public int getId() {
		return id;
	}

	public int[] getTickets() {
		return tickets;
	}

	public int getPerson() {
		return k;
	}

	public int getTime() {
		return time;
	}

}
