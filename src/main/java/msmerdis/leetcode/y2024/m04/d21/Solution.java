package msmerdis.leetcode.y2024.m04.d21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

import msmerdis.leetcode.SolutionRunner;
import msmerdis.leetcode.SolutionTestCase;

public class Solution implements SolutionRunner {

	@Override
	public int getId() {
		return 1971;
	}

	@Override
	public String getName() {
		return "Find if Path Exists in Graph";
	}

	@Override
	public List<SolutionTestCase> testCases() {
		return List.of(
			new TestCase (3, 0, 2, true, new int[][] {
				{0,1},
				{1,2},
				{2,0}
			}),
			new TestCase (6, 0, 5, false, new int[][] {
				{0,1},
				{0,2},
				{3,5},
				{5,4},
				{4,3}
			}),
			new TestCase (6, 0, 5, true, new int[][] {
				{0,1},
				{1,2},
				{3,4},
				{4,5},
				{0,3}
			})
		);
	}

	@Override
	public boolean invoke(SolutionTestCase testCase) {
		if (testCase instanceof TestCase) {
			boolean path = validPath (
				((TestCase)testCase).getN(),
				((TestCase)testCase).getGraph(),
				((TestCase)testCase).getSource(),
				((TestCase)testCase).getTarget()
			);
			return path == ((TestCase)testCase).hasPath();
		}
		return false;
	}

	private BiFunction<? super Integer, ? super Set<Integer>, ? extends Set<Integer>> computeVertex (Integer i) {
		return (key,val) -> {
			if (val == null) {
				val = new HashSet<>();
			}
			val.add(i);
			return val;
		};
	}

	private Map<Integer, Set<Integer>> buildGraph (int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();

		for (int[] edge : edges) {
			graph.compute(edge[0], computeVertex(edge[1]));
			graph.compute(edge[1], computeVertex(edge[0]));
		}

		return graph;
	}

	public boolean validPath(int n, int[][] edges, int source, int destination) {
		if (source == destination) {
			return true;
		}

		Map<Integer, Set<Integer>> graph = buildGraph(edges);
		LinkedList<Integer> queue = new LinkedList<>();

		queue.add(source);

		while (queue.size() > 0) {
			int curr = queue.removeFirst();

			// for each vertex we process remove it from the queue
			// but also remove it from any other node pointing to this one (performed later)
			Set<Integer> list = graph.remove(curr);

			if (list != null) {
				for (int node : list) {
					// if at some point we encounter the target node we return with success
					if (node == destination) {
						return true;
					}

					// otherwise place that node to the queue to be processed as well
					queue.addLast(node);

					// finally remove the vertex to the node leading here to avoid loops
					graph.get(node).remove(curr);
				}
			}
		}

		return false;
	}

}
