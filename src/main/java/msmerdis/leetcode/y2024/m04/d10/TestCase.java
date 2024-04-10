package msmerdis.leetcode.y2024.m04.d10;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private int[] deck;
	private int[] sort;

	public TestCase (int[] deck, int[] sort) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.deck = deck;
		this.sort = sort;
	}

	@Override
	public int getId() {
		return id;
	}

	public int[] getDeck() {
		return deck;
	}

	public int[] getSort() {
		return sort;
	}

}
