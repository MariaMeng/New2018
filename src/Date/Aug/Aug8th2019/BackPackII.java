package Date.Aug.Aug8th2019;

/**
 * Created by apple on 8/8/19.
 */
public class BackPackII {

    /**
     * 空间复杂度：O(n)
     * 找到最大值
     * @param m
     * @param A
     * @param V
     * @return
     */
    public int backPackII(int m, int [] A, int[] V) {
        if (A == null || V == null || m == 0) return -1;
        int[] dp = new int[m + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }
        return dp[m];
    }

    /**
     * 空间复杂度：O(A.length * m)
     * @param m
     * @param A
     * @param V
     */
    public int backPack(int m, int[] A, int[] V) {
        if (A == null || V == null || m == 0) return -1;

        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - A[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public int backPack3(int m, int[] A, int[] V) {
        if (A == null || V == null || m == 0) return -1;

        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j - A[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    public int backPack4(int m, int[] A, int[] V) {
        if (A == null || V == null || m == 0) return -1;

        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - A[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

}
