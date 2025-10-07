import java.util.HashMap;
import java.util.Map;

/**
 * Count Pairs with Given Difference
 * Input Format:
 * First line: integer n, the size of the array
 * Second line: n space-separated integers representing the array nums
 * Third line: integer k
 * Output Format:
 * A single integer representing the number of valid pairs (i, j)
 * Example 1:
 * Input:
 * 5
 * 1 5 3 4 2
 * 2
 * 
 * Output:
 * 3
 * 
 * Explanation
 * The valid pairs are: (1,3), (5,3), (4,2). Each of these has an absolute
 * difference of 2.
 * {
 * 1 > 1
 * 5 > 4
 * 3 > 1
 * }
 */
public class CountPairsWithGivenDifference {
    public int solution(int n, String nums, int k) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap();
        for (String s : nums.split(" ")) {
            int val = Integer.valueOf(s);
            map.put(Integer.valueOf(s), Integer.valueOf(s));
        }
        for (String s : nums.split(" ")) {
            int val = Integer.valueOf(s);
            int kDiff = val + k;
            if (map.containsKey(kDiff)) {
                count++;
            }
            System.out.println(map + " for s: " + s);
        }
        return count;
    }

    public static void main(String[] args) {
        CountPairsWithGivenDifference obj = new CountPairsWithGivenDifference();
        System.out.println(obj.solution(5, "1 5 3 4 2", 2)); // Output: 3
    }
}