import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q16_CycleInDirectedGraph {
    public int solve(int A, int[][] B) {
        int[] inDegree = new int[A];
        int[] visited = new int[A];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            int from = B[i][0];
            int to = B[i][1];
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
        return topo.size() != A ? 1 : 0;
    }

    public static void main(String[] args) {
        Q16_CycleInDirectedGraph solution = new Q16_CycleInDirectedGraph();
        int A1 = 5;
        int[][] B1 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        int result = solution.solve(A1, B1);
        System.out.println("CycleInDirectedGraph : " + result);

        int A2 = 5;
        int[][] B2 = { { 1, 2 }, { 4, 1 }, { 2, 4 }, { 3, 4 }, { 5, 2 }, { 1, 3 } };
        int result2 = solution.solve(A2, B2);
        System.out.println("CycleInDirectedGraph : " + result2);

    }
}