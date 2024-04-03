package msmerdis.leetcode.y2024.m04.d03;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 79;
	}

	@Override
	public String getName() {
		return "Word Search";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		List<String> board = List.of(
			"ABCE",
			"SFCS",
			"ADEE"
		);
		return List.of(
			new TestCase (board, "ABCCED", true),
			new TestCase (board, "SSE",    true),
			new TestCase (board, "ABCB",   true)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			return exist (((TestCase)testCase).getBoard(), ((TestCase)testCase).getWord()) ==
					((TestCase)testCase).doesExist();
		}
		return false;
	}

	public boolean exist (char[][] board, String word) {
		int i;
		int j;

		for (i = 0; i < board.length; i += 1) {
			for (j = 0; j < board[i].length; j += 1) {
				if (check (board, word.toCharArray(), i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean check (char[][] board, char[] word, int i, int j, int k) {
		if (k >= word.length) {
			return true;
		}
		if (i < 0 || board.length <= i) {
			return false;
		}
		if (j < 0 || board[i].length <= j) {
			return false;
		}
		if (board[i][j] != word[k]) {
			return false;
		}
		board[i][j] = 0;
		if (
			check(board, word, i + 1, j, k + 1) ||
			check(board, word, i - 1, j, k + 1) ||
			check(board, word, i, j + 1, k + 1) ||
			check(board, word, i, j - 1, k + 1)
		) {
			return true;
		}
		board[i][j] = word[k];
		return false;
	}
}
