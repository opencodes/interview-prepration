import java.util.*;

public class Q7_ConstructRoads {
    public int solve(int A, int[][] B) {
        if (A == 0 || B.length == 0) {
            return 0;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < A + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < B.length; i++) {
            adjList.get(B[i][0]).add(B[i][1]);
            adjList.get(B[i][1]).add(B[i][0]);
        }
        int[] colors = new int[A + 1];
        Arrays.fill(colors, -1);
        int countColorZero = 0;
        int countColorOne = 0;
        // System.out.println(adjList);
        // System.out.println(Arrays.toString(colors));
        // For all nodes
        for (int i = 1; i <= A; i++) {
            // if not colored
            if (colors[i] == -1) {

                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                colors[i] = 0;
                countColorZero++;

                while (!queue.isEmpty()) {
                    int qSize = queue.size();
                    // System.out.println("qSize " + qSize);
                    for (int j = 0; j < qSize; j++) {
                        int queueItem = queue.poll();
                        List<Integer> neighbours = adjList.get(queueItem);
                        // System.out.println(Arrays.toString(colors));
                        // System.out.println("queueItem " + queueItem + " neighbours " + neighbours);

                        for (Integer neighbour : neighbours) {
                            if (colors[neighbour] == -1) {
                                colors[neighbour] = 1 - colors[queueItem];
                                queue.add(neighbour);
                                if (colors[neighbour] == 0) {
                                    countColorZero++;
                                } else {
                                    countColorOne++;
                                }
                            }
                        }
                    }
                }
            }
        }
        final int MOD = 1000000007;
        // System.out.println("Max edge possible " + maxEdge);
        // System.out.println(countColorZero + " - " + countColorOne);
        // System.out.println(Arrays.toString(colors));
        long maxEdge = 1L * countColorOne * countColorZero; // avoid overflow
        long result = maxEdge - B.length;

        return (int) ((result % MOD + MOD) % MOD);
    }

    public static void main(String[] args) {
        int A = 2;
        int[][] B = { { 2, 1 } };
        Q7_ConstructRoads solution = new Q7_ConstructRoads();
        System.out.println("Input :");
        System.out.println(" - A: " + A);
        System.out.println(" - B: " + Arrays.deepToString(B));
        System.out.println(solution.solve(A, B)); // Output: 0
    }
}