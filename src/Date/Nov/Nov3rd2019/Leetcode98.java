package Date.Nov.Nov3rd2019;

import java.util.PriorityQueue;

/**
 * Created by apple on 11/3/19.
 */
public class Leetcode98 {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0 && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(numDecodings(s));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
    }
}
