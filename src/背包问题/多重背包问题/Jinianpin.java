package 背包问题.多重背包问题;

import java.util.Scanner;

/**
 * Created by apple on 9/30/18.
 * 花花看中了一件非常中意的纪念品，售价m，而她手里有n种纸币，第i种纸币每张币值为Ai，总共有Bi张。然而呢，花花是个极其懒的人，她希望从包里抽出尽量少的纸币去支付这样纪念品，而且她懒得思考，所以想让作为男朋友的你来解决这个简单的问题。

 输入
 第一行两个整数，n和m。（1≤n≤100, 1≤m≤1e8）

 第二行n个正整数，第i个数表示第i种纸币的面值。（1≤Ai≤10000）

 第三行n个正整数，第i个数表示第i种纸币的数量。（1≤Bi≤100）

 输出
 一个正整数，所需的最少的纸币张数，保证花花有足够的钱可以购买这件纪念品

 样例输入
 3 100
 10 20 50
 1 10 1
 样例输出
 4
 */
public class Jinianpin {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            B[i] = in.nextInt();
        }

        int res = findMin(A, B, m);
        System.out.println(res);
    }

    private static int findMin(int[] weight, int[] limit, int maxWeight){
        int n = weight.length;
        int m = maxWeight;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n + 1][m + 1];
        // 1. set the special case
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = max;
        }
        // 2. traverse the whole process
        // dp[i][j]表示前i个物品中放在最大承重为j的包中，最少纸币的个数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = max;
                int nCount = Math.min(limit[i - 1], j / weight[i - 1]);

                for (int k = 0; k <= nCount; k++) {
                    if (dp[i - 1][j - k * weight[i - 1]] != max)
                        dp[i][j] = Math.min(dp[i][j], k + dp[i - 1][j - k * weight[i - 1]]);
                }
            }
        }
        return dp[n][m] == max ? 0 : dp[n][m];
    }
}
