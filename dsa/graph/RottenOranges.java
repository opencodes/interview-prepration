package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {
    Queue<Integer> queue = new LinkedList<>();

    public void bfs(int node) {
        queue.add(node);

    }

    public int solve(int[][] A) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            adjList.set(i, new ArrayList<>());
            for (int j = 0; j < A.length; j++) {
                adjList.get(i).add(A[i][j]);
            }
        }

        return 0;
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
            int result = solution.solve(A);
            System.out.println("Input: A = " + java.util.Arrays.deepToString(A));
            System.out.println("Output: " + result);
        }
    }
}

/**
 * Q1. Rotten Oranges
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description

Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. 
Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints

1 <= N, M <= 1000

0 <= A[i][j] <= 2



Input Format

The first argument given is the integer matrix A.



Output Format

Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



Example Input

Input 1:


A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]


Input 2:


 
A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]








Example Output

Output 1:

 4
Output 2:

 -1


Example Explanation

Explanation 1:

Minute 0: [ [2, 1, 1]
            [1, 1, 0]
            [0, 1, 1] ]
Minute 1: [ [2, 2, 1]
            [2, 1, 0]
            [0, 1, 1] ]
Minute 2: [ [2, 2, 2]
            [2, 2, 0]
            [0, 1, 1] ]
Minute 3: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 1] ]
Minute 4: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 2] ]
At Minute 4, all the oranges are rotten.
Explanation 2:

The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.


 */
