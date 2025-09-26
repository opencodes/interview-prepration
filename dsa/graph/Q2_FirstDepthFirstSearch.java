package dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class Q2_FirstDepthFirstSearch {

    private void dfs(int start, int[] visited, List<List<Integer>> adjList){
        visited[start] = 1;
        List<Integer> neighList = adjList.get(start);
        for (int i = 0; i < neighList.size(); i++) {
            int neighbour = neighList.get(i);
            if (visited[neighbour]!=1) {
                dfs(neighbour,  visited, adjList);
            }
        }
    }
    
    public int solve(int[] A, final int B, final int C) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i <= A.length; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        // Build adjacency list
        for (int i = 1; i < A.length; i++) {
            int startNode = i+1;
            int endNode = A[i];
            adjList.get(startNode).add(endNode);
        }

        int[] visited = new int[adjList.size()]; 
        dfs(B,   visited, adjList);
        return visited[C];
    }

    public static void main(String[] args) {
        Q2_FirstDepthFirstSearch solution = new Q2_FirstDepthFirstSearch();

       int[][] testCases = {
             {1, 1, 2},
              {1, 1, 2}
        };
        int[] B = {1, 2};
        int[] C = {2, 1};

        for (int i = 0; i < testCases.length; i++) {
            int[] a = testCases[i];
            int b = B[i];
            int c = C[i];
            int result = solution.solve(a,b,c);
            System.out.println("Input: A = " + a.toString() + ", B = " + b + ", C = " + c);
            System.out.println("Output: " + result);
        }
    }
}
