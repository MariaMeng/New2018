package Date.Aug.Aug5th2019;

/**
 * Created by apple on 8/5/19.
 */
public class DP {

    public static int exchange(int[] penny, int n, int aim) {
        if (n == 0) return -1;

        // 货币0-n 中组成aim 的组合数
        int[][] dp = new int[n][aim + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = penny[0]; j <= aim; j = j + penny[0]) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - penny[i] >= 0) {
                    dp[i][j] = dp[i][j] + dp[i][j - penny[i]];
                }
            }
        }
        return dp[n - 1][aim];
    }


    public static int exchange2(int[] penny, int n , int aim) {
        if (n == 0) return -1;

        int[] dp = new int[aim + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = penny[i]; j <= aim; j++) {
                dp[j] += dp[j - penny[i]];
            }
        }
        return dp[aim];
    }
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 4};
        int n = 3, aim = 3;
        int res = exchange2(data, n, aim);
        System.out.println(res);
    }


}
