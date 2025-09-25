import java.util.ArrayList;
import java.util.List;

public class Solution {

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
        System.out.println(adjList);

        return visited[A];
    }

    public static void main(String[] args) {
        int A = 2;
        int[][]  B = { 
            {1, 2}
        };

        Solution solution = new Solution();
        int result = solution.solve(A, B);
        System.out.println("Output: " + result);
    }
}