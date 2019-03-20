package Algorithm;

/**
 * Created by apple on 11/8/18.
 *
 * 最长重复子序列
 */
public class LongestRepeatingSubsequence {
    public int longestRepeatingSubsequence(String str) {
        // write your code here
        if (str == null || str.length() == 0) return 0;
        int total = 0, single = 0;
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}
