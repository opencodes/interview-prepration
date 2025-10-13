import java.util.*;
import java.util.List;

/**
 * Problem Description
 * You are given N towns (1 to N). All towns are connected via unique directed
 * path as mentioned in the input.
 * Given 2 towns find whether you can reach the first town from the second
 * without repeating any edge.
 * B C : query to find whether B is reachable from C.
 * 
 * Input contains an integer array A of size N and 2 integers B and C ( 1 <= B,
 * C <= N ).
 * There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's
 * guaranteed that A[i] <= i for every 1 <= i < N.
 * NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't
 * represent any edge.
 * 
 * Problem Constraints
 * 1 <= N <= 100000
 * 
 * Input Format
 * - First argument is vector A
 * - Second argument is integer B
 * - Third argument is integer C
 * 
 * Output Format
 * - Return 1 if reachable, 0 otherwise.
 */

public class Q2_FirstDepthFirstSearch {

	public int solve(int[] A, int B, int C) {
		// Create an adjacency list to represent the directed graph
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < A.length + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 1; i < A.length; i++) {
			graph.get(A[i]).add(i + 1);
		}

		// Perform DFS to check if there's a path from node 1 to node A
		boolean[] visited = new boolean[A.length + 1];
		return dfs(graph, visited, C, B) ? 1 : 0;
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
		Q2_FirstDepthFirstSearch solution = new Q2_FirstDepthFirstSearch();

		int[] A2 = { 1, 1, 2 };
		int B2 = 1;
		int C2 = 2;
		System.out.println(solution.solve(A2, B2, C2)); // Output: 1
	}

}