package Packaging.ZeroOne;

import java.util.Scanner;

/**
 * Created by apple on 10/2/18.
 * 杭电1203
 *
 * Speakless很早就想出国，现在他已经考完了所有需要的考试，准备了所有要准备的材料，于是，便需要去申请学校了。
 * 要申请国外的任何大学，你都要交纳一定的申请费用，这可是很惊人的。Speakless没有多少钱，总共只攒了n万美元。
 * 他将在m个学校中选择若干的（当然要在他的经济承受范围内）。每个学校都有不同的申请费用a（万美元），
 * 并且Speakless估计了他得到这个学校offer的可能性b。不同学校之间是否得到offer不会互相影响。“I NEED A OFFER”，他大叫一声。
 * 帮帮这个可怜的人吧，帮助他计算一下，他可以收到至少一份offer的最大概率。（如果Speakless选择了多个学校，得到任意一个学校的offer都可以）。

 Input
 输入有若干组数据，每组数据的第一行有两个正整数n,m(0<=n<=10000,0<=m<=10000)
 后面的m行，每行都有两个数据ai(整型),bi(实型)分别表示第i个学校的申请费用和可能拿到offer的概率。
 输入的最后有两个0。

 Output
 每组数据都对应一个输出，表示Speakless可能得到至少一份offer的最大概率。用百分数表示，精确到小数点后一位。

 Sample Input
 10 3
 4 0.1
 4 0.2
 5 0.3
 0 0

 Sample Output

 44.0%
 */
public class INeedAOffer {
    public static void main(String[] args ) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0 && m == 0) break;

            float[] a = new float[m];
            float[] b = new float[m];

            for (int i = 0; i < m; i++) {
                a[i] = in.nextInt();
                b[i] = in.nextFloat();
            }
            float res = findMaxPro(a, b, n);
            System.out.println(String.format("%.1f", res * 100) + "%");
        }
    }
    public static float findMaxPro(float[] V, float[] P, int maxWegiht) {
        if (V.length == 0 || P.length == 0) return Float.MIN_VALUE;
        int n = V.length;
        int M = maxWegiht;
        float[][] dp = new float[n + 1][M + 1];
        float max = Float.MAX_VALUE;

        dp[0][0] = 1;

        for (int j = 1; j <= M; j++) {
            dp[0][j] = max;
        }

        for (int i = 1; i <= n; i++) {
            if (V[i - 1] == 0)
                dp[i][0] = 1 - P[i - 1];
            else dp[i][0] = 1;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = max;
                if (j - V[i - 1] >= 0 && dp[i - 1][j - (int)V[i - 1]] != max) {
                    dp[i][j] = Math.min(dp[i - 1][j], (1 - P[i - 1]) * dp[i - 1][j - (int)V[i - 1]]);
                } else
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return ((dp[n][M] != max) ? (1 - dp[n][M]) : 0);
    }
}
