package msmerdis.leetcode.y2024.m04.d23;

import java.util.List;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private int nodes;
	private int[][] edges;
	private List<Integer> roots;

	public TestCase (int nodes, int[][] edges, List<Integer> roots) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.edges = edges;
		this.nodes = nodes;
		this.roots = roots;
	}

	@Override
	public int getId() {
		return id;
	}

	public int[][] getEdges() {
		return edges;
	}

	public int getNodes() {
		return nodes;
	}

	public List<Integer> getRoots() {
		return roots;
	}

}
