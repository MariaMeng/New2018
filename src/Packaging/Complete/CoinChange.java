package Packaging.Complete;

/**
 * Created by apple on 10/14/18.
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // write your code here
        if (coins == null || coins.length == 0) return -1;
        int n = coins.length, M = amount;
        int[][] dp = new int[n + 1][M + 1];
        int max = Integer.MAX_VALUE;
        for (int j = 1; j <= M; j++)
            dp[0][j] = max;
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= M; j++) {
                int left = max;
                dp[i][j] = max;
                if (j - coins[i - 1] >= 0 && dp[i][j - coins[i - 1]] != max) {
                    left = 1 + dp[i][j - coins[i - 1]];
                }
                dp[i][j] = Math.min(dp[i - 1][j], left);
            }
        }
        return dp[n][M];
    }
    public static void main(String[] args) {
        int[] coins = new int[] {0, 1, 1};
        int amount = 2;
        System.out.println(coinChange(coins, amount));
    }
}
