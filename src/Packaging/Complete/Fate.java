package Packaging.Complete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by apple on 10/3/18.
 * 杭电 2159
 *
 * 最近xhd正在玩一款叫做FATE的游戏，为了得到极品装备，xhd在不停的杀怪做任务。久而久之xhd开始对杀怪产生的厌恶感，
 * 但又不得不通过杀怪来升完这最后一级。现在的问题是，xhd升掉最后一级还需n的经验值，xhd还留有m的忍耐度，每杀一个怪xhd会得到相应的经验，
 * 并减掉相应的忍耐度。当忍耐度降到0或者0以下时，xhd就不会玩这游戏。xhd还说了他最多只杀s只怪。请问他能升掉这最后一级吗？

 Input
 输入数据有多组，对于每组数据第一行输入n，m，k，s(0 < n,m,k,s < 100)四个正整数。分别表示还需的经验值，保留的忍耐度，
 怪的种数和最多的杀怪数。接下来输入k行数据。每行数据输入两个正整数a，b(0 < a,b < 20)；
 分别表示杀掉一只这种怪xhd会得到的经验值和会减掉的忍耐度。(每种怪都有无数个)

 Output
 输出升完这级还能保留的最大忍耐度，如果无法升完这级输出-1。

 Sample Input
 10 10 1 10
 1 1
 10 10 1 9
 1 1
 9 10 2 10
 1 1
 2 2

 Sample Output
 0
 -1
 1
 */
public class Fate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int n = in.nextInt();
            if (n == -1) break;
            int m = in.nextInt();
            int k = in.nextInt();
            int s = in.nextInt();
            int[] a = new int[k];
            int[] b = new int[k];

            for (int i = 0; i < k; i++) {
                a[i] = in.nextInt();
                b[i] = in.nextInt();
            }

            int res = findMaxTol(a, b, n, m, s);
            System.out.println(res);
        }

        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(1);




    }

    public static int findMaxTol(int[] W, int[] V, int maxWeight, int totalTol, int maxNum) {
        if (W.length == 0 || V.length == 0) return -1;
        int n = W.length;
        int M = maxWeight;
        int S = maxNum;

        int[][][] dp = new int[n + 1][M + 1][S + 1];
        int max = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= S; k++) {
                    dp[i][j][k] = max;
                }
            }
        }

        dp[0][0][0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k <= S; k++) {
                    int left = max;
                    if (j - W[i - 1] >= 0 && dp[i][j - W[i - 1]][k - 1] != max) {
                        left = V[i - 1] + dp[i][j - W[i - 1]][k - 1];
                    }
                    dp[i][j][k] = Math.min(left, dp[i - 1][j][k]);

                }
            }
        }

        int res = -1;
        for (int k = S; k >= 0; k--) {
            if (dp[n][M][k] != max) {
                res = dp[n][M][k];
                if (totalTol - res >= 0)
                    res = totalTol - res;
                else
                    res = -1;
                break;
            }
        }

        return res;
    }
}
