package Packaging.ZeroOne;

import java.util.Scanner;

/**
 * Created by apple on 10/2/18.
 * ����1203
 *
 * Speakless�������������������Ѿ�������������Ҫ�Ŀ��ԣ�׼��������Ҫ׼���Ĳ��ϣ����ǣ�����Ҫȥ����ѧУ�ˡ�
 * Ҫ���������κδ�ѧ���㶼Ҫ����һ����������ã�����Ǻܾ��˵ġ�Speaklessû�ж���Ǯ���ܹ�ֻ����n����Ԫ��
 * ������m��ѧУ��ѡ�����ɵģ���ȻҪ�����ľ��ó��ܷ�Χ�ڣ���ÿ��ѧУ���в�ͬ���������a������Ԫ����
 * ����Speakless���������õ����ѧУoffer�Ŀ�����b����ͬѧУ֮���Ƿ�õ�offer���ụ��Ӱ�졣��I NEED A OFFER���������һ����
 * �������������˰ɣ�����������һ�£��������յ�����һ��offer�������ʡ������Speaklessѡ���˶��ѧУ���õ�����һ��ѧУ��offer�����ԣ���

 Input
 ���������������ݣ�ÿ�����ݵĵ�һ��������������n,m(0<=n<=10000,0<=m<=10000)
 �����m�У�ÿ�ж�����������ai(����),bi(ʵ��)�ֱ��ʾ��i��ѧУ��������úͿ����õ�offer�ĸ��ʡ�
 ��������������0��

 Output
 ÿ�����ݶ���Ӧһ���������ʾSpeakless���ܵõ�����һ��offer�������ʡ��ðٷ�����ʾ����ȷ��С�����һλ��

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
