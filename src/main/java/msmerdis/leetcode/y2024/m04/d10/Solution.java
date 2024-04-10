package msmerdis.leetcode.y2024.m04.d10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 950;
	}

	@Override
	public String getName() {
		return "Reveal Cards In Increasing Order";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new int[]{17,13,11,2,3,5,7}, new int[]{2,13,3,11,5,17,7}),
			new TestCase (new int[]{17,13,2,3,5,7,11}, new int[]{2,13,3,11,5,17,7}),
			new TestCase (new int[] {1, 1000}, new int[] {1, 1000})
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			int[] sort = deckRevealedIncreasing (((TestCase)testCase).getDeck());
			return Arrays.equals(sort, ((TestCase)testCase).getSort());
		}
		return false;
	}

	public int[] deckRevealedIncreasing(int[] deck) {
		// create a linked list to easily manipulate the deck
		List<Integer> sort = new LinkedList<>();

		// sort the deck
		Arrays.sort(deck);

		// and process numbers from last to first
		// reverting the operations
		for (int i = deck.length - 1; i >= 0; i -= 1) {
			// first take the last item and move it to the front
			// the reverse operation of taking the top and adding it to the end
			if (sort.size() > 1) {
				sort.addFirst(sort.removeLast());
			}
			// then add the element to the front of the queue
			// the reverse operation of taking the top card out of the deck
			sort.addFirst(deck[i]);
		}
		// convert back to an array
		for (int i = 0; i < deck.length; i += 1) {
			deck[i] = sort.removeFirst();
		}
		// and return it
		return deck;
		
	}
}
