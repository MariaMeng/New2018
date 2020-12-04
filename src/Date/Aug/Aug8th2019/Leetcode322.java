package Date.Aug.Aug8th2019;

/**
 * Created by apple on 8/8/19.
 */
public class Leetcode322 {

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        int MAX_VALUE = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = MAX_VALUE;
            }
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i - 1] >= 0 && dp[i][j - coins[i - 1]] != MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[n][amount] == MAX_VALUE ? -1 : dp[n][amount];
    }
    public static int coinChange1(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int n = coins.length;
        int[] dp = new int[amount + 1];
        int MAX_VALUE = Integer.MAX_VALUE;


        for (int j = 1; j <= amount; j++) {
            dp[j] = MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == MAX_VALUE ? -1 : dp[amount];
    }


    public static int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int n = coins.length;
        int[] dp = new int[amount + 1];
        int MAX_VALUE = Integer.MAX_VALUE;

        for (int j = 1; j <= amount; j++) {
            dp[j] = MAX_VALUE;
        }

        for (int j = coins[0]; j <= amount; j+= coins[0]) {
            dp[j] = dp[j - coins[0]] + 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args ){
        int[] coin = new int[]{2};
        int amount = 3;

        int res = coinChange2(coin, amount);
        System.out.println(res);
    }
}
