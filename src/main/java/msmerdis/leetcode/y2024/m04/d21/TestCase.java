package msmerdis.leetcode.y2024.m04.d21;

import msmerdis.leetcode.SolutionTestCase;

public class TestCase implements SolutionTestCase {

	private static int ID_ASSIGN = 0;

	private int id;
	private int n;
	private int[][] graph;
	private int source;
	private int target;
	private boolean path;

	public TestCase (int n, int source, int target, boolean path, int[][] graph) {
		ID_ASSIGN += 1;
		this.id = ID_ASSIGN;
		this.n = n;
		this.graph  = graph;
		this.source = source;
		this.target = target;
		this.path   = path;
	}

	@Override
	public int getId() {
		return id;
	}

	public int getN() {
		return n;
	}

	public int[][] getGraph() {
		return graph;
	}

	public int getSource() {
		return source;
	}

	public int getTarget() {
		return target;
	}

	public boolean hasPath() {
		return path;
	}

}
