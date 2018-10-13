package Packaging.ZeroOne;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by apple on 10/1/18.
 * 杭电2546
 *
 * 电子科大本部食堂的饭卡有一种很诡异的设计，即在购买之前判断余额。如果购买一个商品之前，卡上的剩余金额大于或等于5元，
 * 就一定可以购买成功（即使购买后卡上余额为负），否则无法购买（即使金额足够）。所以大家都希望尽量使卡上的余额最少。
 某天，食堂中有n种菜出售，每种菜可购买一次。已知每种菜的价格以及卡上的余额，问最少可使卡上的余额为多少。


 Input
 多组数据。对于每组数据：
 第一行为正整数n，表示菜的数量。n<=1000。
 第二行包括n个正整数，表示每种菜的价格。价格不超过50。
 第三行包括一个正整数m，表示卡上的余额。m<=1000。

 n=0表示数据结束。


 Output
 对于每组输入,输出一行,包含一个整数，表示卡上可能的最小余额。


 Sample Input

 1
 50
 5
 10
 1 2 3 2 1 1 2 3 2 1
 50
 0



 Sample Output

 -45
 32
 */
public class FanKa {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while ((n = in.nextInt()) != 0) {
            int[] V = new int[n];
            for (int i = 0; i < n; i++) {
                V[i] = in.nextInt();
            }

            int m = in.nextInt();

            int res = findMin(V, m);
            System.out.println(res);
        }
    }
    public static int findMin(int[] V, int MaxValue) {
        if (MaxValue < 5) return MaxValue;
        if (V.length == 0) return Integer.MAX_VALUE;
        int n = V.length;
        int M = MaxValue - 5; // 用5元买最贵的东西

        Arrays.sort(V); // 按照从小到大排序

        int max = V[n - 1]; // 最贵东西的价格

        int[][] dp = new int[n + 1][M + 1];

        // 如果剩余钱币能买最便宜的东西，则求出能够买的最大值
        if (M > V[0]) {

            for (int i = 1; i <= n - 1; i++) {
                for (int j = 1; j <= M; j++) {
                    if (j - V[i - 1] >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], V[i - 1] + dp[i - 1][j - V[i - 1]]);
                    } else
                        dp[i][j] = dp[i - 1][j];
                }
            }

        }

        return M - dp[n - 1][M] + 5 - max;
    }
}
