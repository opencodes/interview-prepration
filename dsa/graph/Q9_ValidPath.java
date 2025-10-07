import java.util.*;

public class Q9_ValidPath {
    static int[] x = { 1, 1, 1, -1, -1, -1, 0, 0 };
    static int[] y = { -1, 1, 0, -1, 1, 0, 1, -1 };

    public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int[][] valid = new int[A + 1][B + 1];
        int n = C;
        int r = D;
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int z = 0; z < n; z++) {
                    if (Math.sqrt(Math.pow(E[z] - i, 2) + Math.pow(F[z] - j, 2)) <= r)
                        valid[i][j] = -1;
                }
            }
        }
        if (valid[0][0] == -1 || valid[A][B] == -1)
            return "NO";
        boolean[][] v = new boolean[A + 1][B + 1];
        v[0][0] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        q.add(0);
        while (!q.isEmpty()) {
            int i = q.poll();
            int j = q.poll();
            for (int z = 0; z < 8; z++) {
                int ix = i + x[z];
                int iy = j + y[z];
                if (!(ix < 0 || iy < 0 || ix >= A + 1 || iy >= B + 1) && !v[ix][iy] && valid[ix][iy] != -1) {
                    if (ix == A && iy == B) {
                        return "YES";
                    }
                    q.add(ix);
                    q.add(iy);
                    v[ix][iy] = true;
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {

        int A = 3;
        int B = 3;
        int C = 1;
        int D = 1;
        int[] E = { 0 };
        int[] F = { 3 };
        Q9_ValidPath solution = new Q9_ValidPath();
        String result = solution.solve(A, B, C, D, E, F);
        System.out.println("ValidPath : " + result);
    }
}
