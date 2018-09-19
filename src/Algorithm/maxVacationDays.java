package Algorithm;

/**
 * Created by apple on 8/19/18.
 */
public class maxVacationDays {
    /**
     * @param flights: the airline status from the city i to the city j
     * @param days: days[i][j] represents the maximum days you could take vacation in the city i in the week j
     * @return: the maximum vacation days you could take during K weeks
     * 从后往前 递推遍历：http://www.cnblogs.com/grandyang/p/6919389.html
     */

    public int maxVacationDays(int[][] flights, int[][] days) {
        // Write your code here

        int N = flights.length;
        int K = days[0].length;

        int[][] dp = new int[N][K];
        int res = 0;

        for (int j = K - 1; j >= 0; j--) {
            for (int i = 0; i < N; i++) {
                dp[i][j] = days[i][j];

                for (int p = 0; p < N; ++p) {
                    if (j < K - 1 && (flights[i][p] != 0|| i == p)) { // 不是最后一周并且，如过city i 至 city p 之间有航班或者相等。
                        dp[i][j] = Math.max(dp[i][j], dp[p][j + 1] + days[i][j]);
                    }

                    if (j == 0 && (i == 0 || flights[0][i] != 0)) { // 第0周时，就在城市0，或者城市0 到其他城市有航班
                        res = Math.max(res, dp[i][0]);
                    }
                }
            }
        }

        return res;
    }


}
