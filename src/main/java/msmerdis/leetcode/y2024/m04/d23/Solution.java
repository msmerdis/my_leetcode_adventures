package msmerdis.leetcode.y2024.m04.d23;

import java.util.LinkedList;
import java.util.List;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 310;
	}

	@Override
	public String getName() {
		return "Minimum Height Trees";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (4, new int[][] {
				{1,0},
				{1,2},
				{1,3}
			}, List.of(1)),
			new TestCase (6, new int[][] {
				{3,0},
				{3,1},
				{3,2},
				{3,4},
				{5,4}
			}, List.of(3,4)),
			new TestCase (1, new int[][] {
			}, List.of(0))
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			List<Integer> roots = findMinHeightTrees (
				((TestCase)testCase).getNodes(),
				((TestCase)testCase).getEdges()
			);
			return
				roots.containsAll(((TestCase)testCase).getRoots()) &&
				((TestCase)testCase).getRoots().containsAll(roots);
		}
		return false;
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		int[] neighbours = new int[n];
		int[] parent = new int[n];
		int nodes = 0;
		List<Integer> leafs = new LinkedList<Integer>();

		// initialize neighbours
		for (int[] edge : edges) {
			neighbours[edge[0]] += 1;
			neighbours[edge[1]] += 1;

			// accumulate all parents into a single variable
			// and keep removing them as nodes get removed
			// when the number of neighbours are 1
			// then this will only contain one edge
			// the parent of the node
			parent[edge[0]] ^= edge[1];
			parent[edge[1]] ^= edge[0];
		}

		// add all leafs to a list
		// count the remaining nodes
		for (int i = 0; i < n; i += 1) {
			if (neighbours[i] < 2) {
				leafs.add(i);
			} else {
				nodes += 1;
			}
		}

		// while there are still nodes remaining in the graph
		// remove the leafs updating their parent information
		// and update a new list of leafs of the remaining tree
		//
		// repeat until the remaining nodes are exhausted
		// the last set of leafs will be the result
		while (nodes > 0) {
			List<Integer> list = new LinkedList<Integer>();
			for (int leaf : leafs) {
				parent[parent[leaf]] ^= leaf;
				neighbours[parent[leaf]] -= 1;
				if (neighbours[parent[leaf]] == 1) {
					list.add(parent[leaf]);
				}
			}
			nodes -= list.size();
			leafs = list;
		}

		return leafs;
	}

}
