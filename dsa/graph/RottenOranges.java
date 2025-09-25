package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

    public int solve(int[][] A) {
        Queue<int[]> queue = new LinkedList<>();
        int m = A.length;
        int n = A[0].length;
        int freshCount = 0;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (A[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return -1;
        }
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        System.err.println(queue.size());
        while (!queue.isEmpty()) {

            boolean rooted = false;

            for (int k = 0; k < queue.size(); k++) {
                int[] node = queue.poll();
                int i = node[0];
                int j = node[1];
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    System.err.println("ni " + ni + "---- nj" + nj);
                    if (ni >= 0 && nj >= 0 && ni < m && nj < m && A[ni][nj] == 1) {
                        A[ni][nj] = 2;
                        queue.add(new int[] { ni, nj });
                        freshCount--;
                        rooted = true;
                        System.out.println(ni + "--" + nj);
                    }
                }
            }
            if (rooted) {
                System.out.println("count:" + count);
                count++;
            }

        }
        return freshCount == 0 ? count : -1;
    }

    public static void main(String[] args) {
        RottenOranges solution = new RottenOranges();
        int[][][] testCases = {
                {
                        { 2, 1, 1 },
                        { 1, 1, 0 },
                        { 0, 1, 1 }
                }
        };
        for (int i = 0; i < testCases.length; i++) {
            int[][] A = testCases[i];
            System.out.println("Input: A = " + java.util.Arrays.deepToString(A));
            int result = solution.solve(A);
            System.out.println("Input: A = " + java.util.Arrays.deepToString(A));
            System.out.println("Output: " + result);
        }
    }
}

/**
 * Q1. Rotten Oranges
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 * 
 * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 * 
 * Each cell can have three values:
 * 
 * The value 0 representing an empty cell.
 * 
 * The value 1 representing a fresh orange.
 * 
 * The value 2 representing a rotten orange.
 * 
 * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom)
 * to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange.
 * If this is impossible, return -1 instead.
 * 
 * Note: Your solution will run on multiple test cases. If you are using global
 * variables, make sure to clear them.
 * 
 * 
 * 
 * Problem Constraints
 * 
 * 1 <= N, M <= 1000
 * 
 * 0 <= A[i][j] <= 2
 * 
 * 
 * 
 * Input Format
 * 
 * The first argument given is the integer matrix A.
 * 
 * 
 * 
 * Output Format
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange.
 * 
 * If this is impossible, return -1 instead.
 * 
 * 
 * 
 * Example Input
 * 
 * Input 1:
 * 
 * 
 * A = [ [2, 1, 1]
 * [1, 1, 0]
 * [0, 1, 1] ]
 * 
 * 
 * Input 2:
 * 
 * 
 * 
 * A = [ [2, 1, 1]
 * [0, 1, 1]
 * [1, 0, 1] ]
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example Output
 * 
 * Output 1:
 * 
 * 4
 * Output 2:
 * 
 * -1
 * 
 * 
 * Example Explanation
 * 
 * Explanation 1:
 * 
 * Minute 0: [ [2, 1, 1]
 * [1, 1, 0]
 * [0, 1, 1] ]
 * Minute 1: [ [2, 2, 1]
 * [2, 1, 0]
 * [0, 1, 1] ]
 * Minute 2: [ [2, 2, 2]
 * [2, 2, 0]
 * [0, 1, 1] ]
 * Minute 3: [ [2, 2, 2]
 * [2, 2, 0]
 * [0, 2, 1] ]
 * Minute 4: [ [2, 2, 2]
 * [2, 2, 0]
 * [0, 2, 2] ]
 * At Minute 4, all the oranges are rotten.
 * Explanation 2:
 * 
 * The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.
 * 
 * 
 */
