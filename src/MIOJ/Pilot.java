package MIOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by apple on 1/3/19.
 */
public class Pilot {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            System.out.println(solution(in.nextLine()));
        }

    }


    private static String solution(String line) {
        if (line == null || line.length() == 0) return "false";
        String[] str = line.split(",");
        if (str.length == 0) return "false";

        int n = str.length; // 商品个数
        int[] weight = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(str[i]);
            sum += weight[i];
        }

        Arrays.sort(weight);

        if (sum % 2 != 0) return "false";

        // 01 背包, dp[i][j] 表示当前背包最大容积为j的情况下,装入第i种商品后最大的体积
        int m = sum / 2; // 背包最大的容积
        int[][] dp = new int[n + 2][m + 1];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= m; j++) {
                if (j - weight[i - 1] >= 0)
                    dp[i][j] = Math.max(dp[i + 1][j], weight[i - 1] + dp[i + 1][j - weight[i - 1]]);
                else
                    dp[i][j] = dp[i + 1][j];
            }
        }
        return dp[1][m] == m ? "true" : "false";
    }
}
