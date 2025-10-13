import java.util.HashMap;
import java.util.Map;

/**
 * Find the minimum integer value of k such that Koko can finish all the bananas
 * within h hours.
 * Input Format:
 * The first line contains an integer n, the number of piles.
 * The second line contains n space-separated integers representing piles[i].
 * The third line contains an integer h, the total number of hours available.
 * Output Format:
 * Print a single integer, the minimum speed k at which Koko must eat to finish
 * all bananas within h hours.
 * 
 * Example 1:
 * Input:
 * 3
 * 5 10 3
 * 4
 * Output:
 * 5
 */
public class KokoEatingBananas {

    public int solution(int n, String piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int[] pilesCountArr = new int[n];
        int index = 0;
        for (String s : piles.split(" ")) {
            pilesCountArr[index] = Integer.valueOf(s);
            high = Math.max(high, Integer.valueOf(s));
            index++;
        }
        System.out.println("Low: " + low + " High: " + high);

        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean canFinish = canFinish(pilesCountArr, h, mid);
            System.out.println("Low: " + low + " High: " + high + " mid: " + mid + " canFinish " + canFinish);

            if (canFinish) {
                high = mid; // try smaller k
            } else {
                low = mid + 1; // need faster speed
            }

        }
        return low;
    }

    private static boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceiling division
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas obj = new KokoEatingBananas();
        System.out.println(obj.solution(4, "3 6 7 11", 8)); // Output: 5
    }
}
