package DP;

/**
 * Created by apple on 10/8/18.
 */
public class Exchange {
    public int countWays(int[] penny, int n, int aim) {
        // write code here
        if (n == 0) return -1;
        int[][] dp = new int[n + 1][aim + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j - penny[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - penny[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][aim];
    }
    public static void main(String[] args) {
        int n = 10;
        while (n > 0) {
            if (n-- == 9)
                System.out.println("10");
            else if (n-- == 9)
                System.out.println("9");
            else if (n-- == 9)
                System.out.println("8");
        }
    }

}
