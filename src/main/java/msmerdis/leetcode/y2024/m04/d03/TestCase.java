package msmerdis.leetcode.y2024.m04.d03;

import java.util.List;
import java.util.stream.Collectors;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private List<String> table;
	private String word;
	private boolean exists;

	public TestCase (List<String> table, String word, boolean exists) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.table = table;
		this.word = word;
		this.exists = exists;
	}

	@Override
	public int getId() {
		return id;
	}

	public char[][] getBoard() {
		List<char[]> list = table.stream().map(String::toCharArray).collect(Collectors.toList());
		return list.toArray(new char[list.size()][]);
	}

	public String getWord() {
		return word;
	}

	public boolean doesExist() {
		return exists;
	}

}
