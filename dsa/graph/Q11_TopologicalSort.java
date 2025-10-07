import java.util.*;

public class Q11_TopologicalSort {

    public int[] solve(int A, int[][] B) {
        int[] inDegree = new int[A];
        int[] visited = new int[A];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            int from = edge[0];
            int to = edge[1];
            inDegree[to - 1] += 1;
            graph.get(from - 1).add(to - 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        List<Integer> topo = new ArrayList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int item = pq.poll();
            if (visited[item] != 1) {
                visited[item] = 1;
                topo.add(item + 1);
                List<Integer> adj = graph.get(item);
                adj.sort((c1, c2) -> c2 - c1);
                for (int i = 0; i < adj.size(); i++) {
                    int neighbour = adj.get(i);
                    if (visited[neighbour] != 1) {
                        inDegree[neighbour] -= 1;
                        if (inDegree[neighbour] == 0) {
                            pq.offer(neighbour);
                        }
                    }
                }

            }
        }
        return topo.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Q11_TopologicalSort solution = new Q11_TopologicalSort();
        // int[][] B1 = { { 6, 1 }, { 6, 3 }, { 5, 2 }, { 5, 1 }, { 3, 4 }, { 4, 2 } };
        // int[] result = solution.solve(6, B1);
        // // Print array
        // System.out.println("TopologicalSort : " + Arrays.toString(result));

        // int[][] B2 = { { 1, 2 }, { 2, 3 }, { 3, 1 }, { 4, 3 } };
        // int[] result2 = solution.solve(4, B2);
        // System.out.println("TopologicalSort : " + Arrays.toString(result2));

        int[][] B3 = { { 1, 4 }, { 1, 2 }, { 4, 2 }, { 4, 3 }, { 3, 2 }, { 5, 2 }, { 3, 5 }, { 8, 2 }, { 8, 6 } };
        int[] result3 = solution.solve(8, B3);
        System.out.println("TopologicalSort : " + Arrays.toString(result3));
        // output - 1 4 3 5 7 8 2 6

        int[][] B4 = { { 6, 3 }, { 6, 1 }, { 5, 1 }, { 5, 2 }, { 3, 4 }, { 4, 2 } };
        int[] result4 = solution.solve(6, B4);
        System.out.println("TopologicalSort : " + Arrays.toString(result4));
        // output - 6 5 3 4 2 1

    }
}