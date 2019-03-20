package Algorithm;

import java.util.*;
/**
 * Created by apple on 10/25/18.
 */
public class FatMouseAndCheese {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, k;
        while ((n = in.nextInt()) != -1 && (k = in.nextInt()) != -1) {
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            int res = findMax(matrix, n, k);
            System.out.println(res);
        }
    }

    public static int findMax(int[][] matrix, int n, int k) {
        if (n == 0 || k <= 0) return -1;
        int[][] dp = new int[n][n];
        int[][] neib = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        return helper(matrix, dp, 0, 0, k, neib);
    }

    public static int helper(int[][] matrix, int[][] dp, int i, int j, int k, int[][] neib) {
        int n = matrix.length;
        if (dp[i][j] != 0) return dp[i][j];

        int ans = 0;
        for (int a = 0; a < 4; a++) {
            for (int b = 1; b <= k; b++) {
                int x = i + neib[a][0] * b;
                int y = j + neib[a][1] * b;
                if (isOK(x, y, n) && matrix[x][y] > matrix[i][j])
                    ans = Math.max(ans, helper(matrix, dp, x, y, k, neib));
            }
        }
        dp[i][j] += matrix[i][j] + ans;
        return dp[i][j];
    }
    public static boolean isOK(int i, int j, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n) return false;
        return true;
    }
}
