import java.util.*;

public class Q8_CycleInUndirectedGraph {
    public boolean bfs(int start, List<List<Integer>> adjList, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        int[] node = { start, -1 };
        queue.add(node);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] pollNode = queue.poll();
            int parent = pollNode[1];
            List<Integer> neighbours = adjList.get(pollNode[0]);
            // System.out.println("neighbours " + neighbours + " of " + parent);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    int[] neighbourNode = { neighbour, pollNode[0] };
                    queue.add(neighbourNode);
                    visited[neighbour] = true;
                } else if (neighbour != parent) {
                    System.out.println("Cycle Detected at " + parent);
                    return true;
                } else {

                }
            }
        }
        return false;
    }

    public int solve(int A, int[][] B) {
        if (A == 0 || B.length == 0) {
            return 0;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : B) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[A + 1];
        Arrays.fill(visited, false);
        for (int i = 1; i < A + 1; i++) {
            if (!visited[i]) {
                if (bfs(i, adjList, visited)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 2 } };
        Q8_CycleInUndirectedGraph solution = new Q8_CycleInUndirectedGraph();
        System.out.println("Input :");
        System.out.println(" - A: " + A);
        System.out.println(" - B: " + Arrays.deepToString(B));
        System.out.println(solution.solve(A, B)); // Output: 0
    }

}
