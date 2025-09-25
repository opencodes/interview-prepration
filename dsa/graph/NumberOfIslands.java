package dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {

    private void dfs(int r, int c, int[][] grid, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols)
            return;
        if (grid[r][c] != 1)
            return;
        grid[r][c] = 0; // mark visited

        // 8 directions
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};g
        for (int i = 0; i < 8; i++) {
            dfs(r + dr[i], c + dc[i], grid, rows, cols);
        }
    }

    public int solve(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int rows = grid.length, cols = grid[0].length;
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    count++;
                    dfs(r, c, grid, rows, cols);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        int[][][] testCases = {
                {
                        { 0, 1, 0 },
                        { 0, 0, 1 },
                        { 1, 0, 0 }
                },
                {

                        { 1, 1, 0, 0, 0 },
                        { 0, 1, 0, 0, 0 },
                        { 1, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0 },
                        { 1, 0, 1, 0, 1 }

                },
                 {
                    { 0, 0, 1, 0, 1, 0, 1, 1, 1 },
                    { 0, 1, 0, 0, 1, 1, 1, 0, 1 }
            }
        };
        for (int i = 0; i < testCases.length; i++) {
            int[][] A = testCases[i];
            int result = solution.solve(A);
            System.out.println("Input: A = " + java.util.Arrays.deepToString(A));
            System.out.println("Output: " + result);
        }
    }
}