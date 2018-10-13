package Packaging.Multiple;

import java.util.Scanner;

/**
 * Created by apple on 9/30/18.
 * 有N种物品，每种物品的数量为C1，C2......Cn。从中任选若干件放在容量为W的背包里，每种物品的体积为W1，W2......Wn（Wi为整数），
 * 与之相对应的价值为P1,P2......Pn（Pi为整数）。求背包能够容纳的最大价值。
 Input

 第1行，2个整数，N和W中间用空格隔开。N为物品的种类，W为背包的容量。(1 <= N <= 100，1 <= W <= 50000)
 第2 - N + 1行，每行3个整数，Wi，Pi和Ci分别是物品体积、价值和数量。(1 <= Wi, Pi <= 10000， 1 <= Ci <= 200)

 Output

 输出可以容纳的最大价值。

 Input示例

 3 6
 2 2 5
 3 3 8
 1 4 1

 Output示例

 9
 */
public class Packing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int M = in.nextInt();

        int[] W = new int[n];
        int[] P = new int[n];
        int[] C = new int[n];

        for (int i = 0; i < n; i++) {
            W[i] = in.nextInt();
            P[i] = in.nextInt();
            C[i] = in.nextInt();
        }
        int res = findMaxPrice(W, P, C, M);

        System.out.println(res);

    }

    public static int findMaxPrice(int[] W, int[] P, int[] C, int M) {
        if (W.length == 0 || P.length == 0 || C.length == 0) return  -1;
        int n = W.length;

        int[][] dp = new int[n + 1][M + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = 0;

                int nCount = Math.min(C[i - 1], j / W[i - 1]);

                for (int k = 0; k <= nCount; k++) {
                    dp[i][j] = Math.max(dp[i][j], k * P[i - 1] + dp[i - 1][j - k * W[i - 1]]);
                }

            }
        }
        return dp[n][M];
    }

}
