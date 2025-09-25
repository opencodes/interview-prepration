package dsa.graph;

import java.util.ArrayList;
import java.util.List;

/**
Q1. Path in Directed Graph
Problem Description : Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:

There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Output Format
Return 1 if path exists between node 1 to node A else return 0.

Example Input
Input 1:
 A = 5
 B = [  [1, 2] 
        [4, 1] 
        [2, 4] 
        [3, 4] 
        [5, 2] 
        [1, 3] ]
Input 2:
 A = 5
 B = [  [1, 2]
        [2, 3] 
        [3, 4] 
        [4, 5] ]


Example Output
Output 1:
 0
Output 2:
 1

Example Explanation

Explanation 1:
 The given doens't contain any path from node 1 to node 5 so we will return 0.

Explanation 2:
 Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.
 */

public class Path_in_Directed_Graph {

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
        Path_in_Directed_Graph solution = new Path_in_Directed_Graph();

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