package Packaging.Multiple;

import java.util.Scanner;

/**
 * Created by apple on 9/30/18.
 * 杭电2191
 *
 * Input
 输入数据首先包含一个正整数C，表示有C组测试用例，每组测试用例的第一行是两个整数n和m(1<=n<=100, 1<=m<=100),分别表示经费的金额和大米的种类，然后是m行数据，每行包含3个数p，h和c(1<=p<=20,1<=h<=200,1<=c<=20)，分别表示每袋的价格、每袋的重量以及对应种类大米的袋数。


 Output
 对于每组测试数据，请输出能够购买大米的最多重量，你可以假设经费买不光所有的大米，并且经费你可以不用完。每个实例的输出占一行。


 Sample Input

 1
 8 2
 2 100 4
 4 100 2



 Sample Output

 400
 */
public class MaiDaMi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int K = in.nextInt();
        for (int k = 0; k < K; k++) {
            int M = in.nextInt();
            int n = in.nextInt();
            int[] P = new int[n];
            int[] H = new int[n];
            int[] C = new int[n];

            for (int i = 0; i < n; i++) {
                P[i] = in.nextInt();
                H[i] = in.nextInt();
                C[i] = in.nextInt();
            }

            int res = findMaxWeight(P, H, C, M);
            System.out.println(res);
        }

    }
    public static int findMaxWeight(int[] P, int[] H, int[] C, int M) {
        if (P.length == 0 || H.length == 0 || C.length == 0) return -1;

        int n = P.length;
        int[][] dp = new int[n + 1][M + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= M; j++) {

                int nCount = Math.min(C[i  - 1], j / P[i - 1]);

                for (int k = 0; k <= nCount; k++) {
                    dp[i][j] = Math.max(dp[i][j], k * H[i - 1] + dp[i - 1][j - k * P[i - 1]]);
                }
            }
        }
        return dp[n][M];
    }

}
