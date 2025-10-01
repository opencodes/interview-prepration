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
        int x = 3, y = 3, N = 1, R = 1;
        ArrayList<Integer> A = new ArrayList<>();
        A.add(0);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(3);
        Q9_ValidPath solution = new Q9_ValidPath();

        System.out.println("Input :");
        System.out.println(" - x: " + x);
        System.out.println(" - y: " + y);
        System.out.println(" - N: " + N);
        System.out.println(" - R: " + R);
        System.out.println(" - A: " + A);
        System.out.println(" - B: " + B);
        System.out.println(solution.solve(x, y, N, R, A, B)); // Output: 0
    }
}
