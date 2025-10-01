import java.util.*;

public class Q6_CheckBipartiteGraph {
    public int solve(int A, int[][] B) {
        if (A == 0 || B.length == 0) {
            return 0;
        }
        boolean isBipartite = true;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : B) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] coloredNode = new int[A];
        Arrays.fill(coloredNode, -1);

        for (int i = 0; i < A; i++) {
            // BFS
            if (coloredNode[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                coloredNode[i] = 0;
                int color = 0;

                while (!queue.isEmpty()) {
                    int size = queue.size();
                    color = 1 - coloredNode[i];

                    for (int k = 0; k < size; k++) {
                        int node = queue.poll();
                        if (coloredNode[node] == -1) {
                            coloredNode[node] = color;
                        }
                        List<Integer> neightbours = adjList.get(node);
                        for (Integer n : neightbours) {
                            if (coloredNode[n] == coloredNode[node]) {
                                return 0;
                            } else {
                                if (coloredNode[n] == -1) {
                                    coloredNode[n] = 1 - coloredNode[node];
                                    queue.add(n);
                                }
                            }
                        }
                    }
                }
            }

        }

        return isBipartite ? 1 : 0;
    }

    public static void main(String[] args) {
        int A = 10;
        int[][] B = { { 7, 8 }, { 1, 2 }, { 0, 9 }, { 1, 3 }, { 6, 7 }, { 0, 3 }, { 2, 5 }, { 3, 8 }, { 4, 8 } };
        Q6_CheckBipartiteGraph solution = new Q6_CheckBipartiteGraph();
        System.out.println("Input :");
        System.out.println(" - A: " + A);
        System.out.println(" - B: " + Arrays.deepToString(B));
        System.out.println(solution.solve(A, B)); // Output: 0
    }
}