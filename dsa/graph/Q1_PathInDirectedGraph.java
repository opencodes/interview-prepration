package dsa.graph;

import java.util.*;

/**
 * Q1. Path in Directed Graph
 * https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 * Example Input
 * Input 1:
 * A = 5
 * B = [ [1, 2]
 * [4, 1]
 * [2, 4]
 * [3, 4]
 * [5, 2]
 * [1, 3] ]
 *
 * Input 2:
 * A = 4
 * B = [ [1, 2]
 * [2, 3]
 * [4, 3] ]
 *
 * Example Output
 * Output 1:
 * 1
 *
 * Output 2:
 * 0
 *
 * Example Explanation
 * Explanation 1:
 * The path from node 1 to node 5 is : 1 -> 2 -> 4 -> 5
 *
 * Explanation 2:
 * There is no path from node 1 to node 4.
 */
class Q1_PathInDirectedGraph {
	public int solve(int A, int[][] B) {
		// Create an adjacency list to represent the directed graph
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= A; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : B) {
			graph.get(edge[0]).add(edge[1]);
		}

		// Perform DFS to check if there's a path from node 1 to node A
		boolean[] visited = new boolean[A + 1];
		return dfs(graph, visited, 1, A) ? 1 : 0;
	}

	private boolean dfs(List<List<Integer>> graph, boolean[] visited, int current, int target) {
		if (current == target) {
			return true;
		}
		visited[current] = true;

		for (int neighbor : graph.get(current)) {
			if (!visited[neighbor]) {
				if (dfs(graph, visited, neighbor, target)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Q1_PathInDirectedGraph solution = new Q1_PathInDirectedGraph();
		int A1 = 5;
		int[][] B1 = { { 1, 2 }, { 4, 1 }, { 2, 4 }, { 3, 4 }, { 4, 5 }, { 1, 3 } };
		System.out.println(solution.solve(A1, B1)); // Output: 1

		int A2 = 5;
		int[][] B2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
		System.out.println(solution.solve(A2, B2)); // Output: 0
	}
}
