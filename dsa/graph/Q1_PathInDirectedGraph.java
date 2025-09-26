package dsa.graph;

import java.util.ArrayList;
import java.util.List;
 
public class Q1_PathInDirectedGraph {
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
    
    public int solve(int A, int[][] B) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        // Build adjacency list
        for (int i = 0; i < B.length; i++) {
            int startNode = B[i][0];
            int endNode = B[i][1];
            adjList.get(startNode).add(endNode);
        }

        int[] visited = new int[adjList.size()]; 
        dfs(1,   visited, adjList);
        return visited[A];
    }

    public static void main(String[] args) {
        Q1_PathInDirectedGraph solution = new Q1_PathInDirectedGraph();

        int[][][] testCases = {
            { {1, 2} },
            { {1, 2}, {2, 3} },
            { {1, 2}, {2, 3}, {3, 4} },
            { {1, 2}, {2, 3}, {3, 1} },
            { {1, 2}, {2, 3}, {4, 5} }
        };
        int[] nodeCounts = {2, 3, 4, 3, 5};

        for (int i = 0; i < testCases.length; i++) {
            int A = nodeCounts[i];
            int[][] B = testCases[i];
            int result = solution.solve(A, B);
            System.out.println("Input: A = " + A + ", B = " + java.util.Arrays.deepToString(B));
            System.out.println("Output: " + result);
        }
    }
}