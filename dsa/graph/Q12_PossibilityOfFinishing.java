import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q12_PossibilityOfFinishing {
    public boolean solve(int A, int[] B, int[] C) {
        int[] inDegree = new int[A];
        int[] visited = new int[A];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            int from = B[i];
            int to = C[i];
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
        return topo.size() == A;
    }

    public static void main(String[] args) {
        Q12_PossibilityOfFinishing solution = new Q12_PossibilityOfFinishing();
        int A1 = 3;
        int[] B1 = { 1, 2 };
        int[] C1 = { 2, 3 };
        boolean result = solution.solve(A1, B1, C1);
        System.out.println("PossibilityOfFinishing : " + result);

        int A2 = 2;
        int[] B2 = { 1, 2 };
        int[] C2 = { 2, 1 };
        boolean result2 = solution.solve(A2, B2, C2);
        System.out.println("PossibilityOfFinishing : " + result2);

    }
}