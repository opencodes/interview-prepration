import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q13_Dijkstra {

    // Input Format
    // - The first argument is an integer A, representing the number of nodes in the
    // graph.
    // - The second argument is a matrix B of size M x 3, where each row represents
    // an edge in the graph. The three columns of each row denote the source node
    // B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
    // - The third argument is an integer C, representing the source node for which
    // the shortest distance to all other nodes needs to be found.

    public int[] solve(int A, int[][] B, int C) {
        int[] visited = new int[A];
        int[] distance = new int[A];
        Arrays.fill(distance, -1);

        List<List<int[]>> list = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            list.get(B[i][0]).add(new int[] { B[i][1], B[i][2] });
            list.get(B[i][1]).add(new int[] { B[i][0], B[i][2] });
        }

        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pQueue.offer(new int[] { C, 0 });
        while (!pQueue.isEmpty()) {
            int[] item = pQueue.poll();
            // if not visited
            if (visited[item[0]] != 1) {
                visited[item[0]] = 1;// mark visited
                distance[item[0]] = item[1]; // set distance
                // find adjecent nodes
                List<int[]> list2 = list.get(item[0]);
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    int[] neighbour = list2.get(i);
                    if (visited[neighbour[0]] != 1) {
                        // update distance as parent distance + item distance
                        neighbour[1] += item[1];
                        pQueue.offer(new int[] { neighbour[0], neighbour[1] });
                    }
                }
            }

        }

        return distance;
    }

    public static void main(String[] args) {
        Q13_Dijkstra solution = new Q13_Dijkstra();

        int A = 6;
        int[][] B = { { 0, 4, 9 }, { 3, 4, 6 }, { 1, 2, 1 }, { 2, 5, 1 }, { 2, 4, 5 }, { 0, 3, 7 }, { 0, 1, 1 },
                { 4, 5, 7 }, { 0, 5, 1 } };
        int C = 4;
        int[] result = solution.solve(A, B, C);
        // Print array
        System.out.println("Dijkstra : " + Arrays.toString(result));

        A = 7;
        B = new int[][] { { 2, 4, 10 }, { 3, 4, 1 }, { 3, 6, 1 }, { 1, 2, 4 }, { 4, 5, 6 } };
        C = 2;
        result = solution.solve(A, B, C);
        // Print array
        System.out.println("Dijkstra : " + Arrays.toString(result));

    }
}