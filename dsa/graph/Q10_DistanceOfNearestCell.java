import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q10_DistanceOfNearestCell {

    public int[][] solve(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int inf = 99999999;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> queue = new LinkedList<>();
        int[][] ans = new int[m][n];
        for (int[] row : ans)
            Arrays.fill(row, inf);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    ans[i][j] = 0;
                    queue.offer(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] item = queue.poll();
                int itemX = item[0];
                int itemY = item[1];

                for (int j = 0; j < dirs.length; j++) {
                    int nItemX = itemX + dirs[j][0];
                    int nItemY = itemY + dirs[j][1];

                    if (nItemX >= 0 && nItemY >= 0 && nItemX < m && nItemY < n) {
                        if (ans[nItemX][nItemY] > ans[itemX][itemY] + 1) {
                            queue.offer(new int[] { nItemX, nItemY });
                            ans[nItemX][nItemY] = ans[itemX][itemY] + 1;
                        }
                        // System.out.println(ans[nItemX][nItemY] + " > " + (ans[itemX][itemY] + 1));

                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Q10_DistanceOfNearestCell solution = new Q10_DistanceOfNearestCell();

        int[][] A1 = { { 1, 0, 0 }, { 0, 0, 0 }, { 1, 0, 0 } };
        int[][] result = solution.solve(A1);
        // Print grid
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}