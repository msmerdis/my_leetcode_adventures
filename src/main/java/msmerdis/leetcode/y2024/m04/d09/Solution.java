package msmerdis.leetcode.y2024.m04.d09;

import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 2073;
	}

	@Override
	public String getName() {
		return "Time Needed to Buy Tickets";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (new int[]{2, 3, 2}, 2, 6),
			new TestCase (new int[]{5, 1, 1, 1}, 0, 8),
			new TestCase (new int[]{5, 1, 1, 1}, 1, 2)
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			int time = timeRequiredToBuy (((TestCase)testCase).getTickets(), ((TestCase)testCase).getPerson());
			return time == ((TestCase)testCase).getTime();
		}
		return false;
	}

	public int timeRequiredToBuy(int[] tickets, int k) {
		// the number of tickets that are to be purchased by user k
		// are the limit for the number of purchases for the other users
		// as each users by tickets one by one
		int l = tickets[k];

		// set the amount of time equal to the limit
		// as that many tickets will be purchased by the person in question
		int t = l;
		int i;

		// people before user k will buy at most the same amount
		// of tickets as user k as user k will leave the queue
		// as soon as all of the tickets are bought
		for (i = 0; i < k; i += 1) {
			t += Math.min(l, tickets[i]);
		}

		// people after user k will buy at most one ticket
		// less than person k, as person k will leave the
		// queue before they have a chance to buy more tickets
		for (i += 1, l -= 1; i < tickets.length; i += 1) {
			t += Math.min(l, tickets[i]);
		}
		return t;
	}
}
