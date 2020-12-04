package Date.Nov.Nov12th2019;

/**
 * Created by apple on 11/12/19.
 */
public class Leetcode322 {

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;

        int m = coins.length;
        int[][] dp = new int[m + 1][amount + 1];

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (j - coins[i - 1] >= 0 && dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                }
            }
        }

        return dp[m][amount] == Integer.MAX_VALUE? -1: dp[m][amount];
    }

    public static void main(String[] args) {
        int[] data = new int[] {5, 2, 1};
        int amout = 12;


        System.out.println(coinChange(data, amout));
    }
}
