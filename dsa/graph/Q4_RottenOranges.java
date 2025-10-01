package dsa.graph;

import java.util.*;

/**
 * Q1. Rotten Oranges
 * 
 * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 * Each cell can have three values:
 * The value 0 representing an empty cell.
 * The value 1 representing a fresh orange.
 * The value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom)
 * to a rotten orange becomes rotten. Return the minimum number of minutes that
 * must elapse until no cell has a fresh orange. If this is impossible, return
 * -1 instead.
 * Note: Your solution will run on multiple test cases. If you are using global
 * variables, make sure to clear them.
 * 
 * Problem Constraints
 * 1 <= N, M <= 1000
 * 0 <= A[i][j] <= 2
 * 
 * Input Format
 * - The first argument given is the integer matrix A.
 * 
 * Output Format
 * - Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange.
 * - If this is impossible, return -1 instead.
 * 
 * Example Input
 * Input 1:
 * A = [ [2, 1, 1]
 * [1, 1, 0]
 * [0, 1, 1] ]
 * Input 2:
 * A = [ [2, 1, 1]
 * [0, 1, 1]
 * [1, 0, 1] ]
 * 
 * Example Output
 * Output 1:
 * 4
 * Output 2:
 * -1
 */

// param A : integer
// param B : array of array of integers
// return an integer
public class Q4_RottenOranges {

	public int solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int freshCount = 0;

		// Initialize the queue with all rotten oranges and count fresh oranges
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 2) {
					queue.offer(new int[] { i, j });
				} else if (A[i][j] == 1) {
					freshCount++;
				}
			}
		}

		if (freshCount == 0) {
			return 0; // No fresh oranges to rot
		}

		int minutes = 0;
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean rottedThisMinute = false;

			for (int i = 0; i < size; i++) {
				int[] orange = queue.poll();
				int x = orange[0];
				int y = orange[1];

				for (int[] dir : directions) {
					int newX = x + dir[0];
					int newY = y + dir[1];

					if (newX >= 0 && newX < n && newY >= 0 && newY < m && A[newX][newY] == 1) {
						A[newX][newY] = 2; // Rot the fresh orange
						queue.offer(new int[] { newX, newY });
						freshCount--;
						rottedThisMinute = true;
					}
				}
			}

			if (rottedThisMinute) {
				minutes++;
			}
		}

		return freshCount == 0 ? minutes : -1;
	}

	public static void main(String[] args) {
		Q4_RottenOranges solution = new Q4_RottenOranges();

		int[][] A1 = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(solution.solve(A1)); // Output: 4

		int[][] A2 = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
		System.out.println(solution.solve(A2)); // Output: -1
	}
}