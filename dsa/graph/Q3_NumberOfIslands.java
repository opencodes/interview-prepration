/**
 * Q. Number of islands
 * Given a matrix of integers A of size N x M consisting of 0 and 1.
 * A group of connected 1's forms an island.
 * From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a
 * corner with (i, j) and value in that cell is 1.
 * More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
 * 
 * Return the number of islands.
 * - NOTE: Rows are numbered from top to bottom and columns are numbered from
 * left to right.
 * Example Input
 * 
 * Input 1:
 * A = [
 * [0, 1, 0]
 * [0, 0, 1]
 * [1, 0, 0]
 * ]
 * Input 2:
 * A = [
 * [1, 1, 0, 0, 0]
 * [0, 1, 0, 0, 0]
 * [1, 0, 0, 1, 1]
 * [0, 0, 0, 0, 0]
 * [1, 0, 1, 0, 1]
 * ]
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 5
 */
public class Q3_NumberOfIslands {

	public int solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		boolean[][] visited = new boolean[n][m];
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 1 && !visited[i][j]) {
					count++;
					dfs(A, visited, i, j, n, m);
				}
			}
		}
		return count;
	}

	private void dfs(int[][] A, boolean[][] visited, int x, int y, int n, int m) {
		if (x < 0 || x >= n || y < 0 || y >= m || A[x][y] == 0 || visited[x][y]) {
			return;
		}
		visited[x][y] = true;

		int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

		for (int dir = 0; dir < 8; dir++) {
			dfs(A, visited, x + dx[dir], y + dy[dir], n, m);
		}
	}

	public static void main(String[] args) {
		Q3_NumberOfIslands solution = new Q3_NumberOfIslands();

		int[][] A1 = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		System.out.println(solution.solve(A1)); // Output: 2

		int[][] A2 = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		System.out.println(solution.solve(A2)); // Output: 5
	}
}