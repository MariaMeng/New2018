package Packaging.Complete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by apple on 10/3/18.
 * ���� 2159
 *
 * ���xhd������һ�����FATE����Ϸ��Ϊ�˵õ���Ʒװ����xhd�ڲ�ͣ��ɱ�������񡣾ö���֮xhd��ʼ��ɱ�ֲ��������У�
 * ���ֲ��ò�ͨ��ɱ�������������һ�������ڵ������ǣ�xhd�������һ������n�ľ���ֵ��xhd������m�����Ͷȣ�ÿɱһ����xhd��õ���Ӧ�ľ��飬
 * ��������Ӧ�����Ͷȡ������ͶȽ���0����0����ʱ��xhd�Ͳ���������Ϸ��xhd��˵�������ֻɱsֻ�֡������������������һ����

 Input
 ���������ж��飬����ÿ�����ݵ�һ������n��m��k��s(0 < n,m,k,s < 100)�ĸ����������ֱ��ʾ����ľ���ֵ�����������Ͷȣ�
 �ֵ�����������ɱ����������������k�����ݡ�ÿ��������������������a��b(0 < a,b < 20)��
 �ֱ��ʾɱ��һֻ���ֹ�xhd��õ��ľ���ֵ�ͻ���������Ͷȡ�(ÿ�ֶֹ���������)

 Output
 ��������⼶���ܱ�����������Ͷȣ�����޷������⼶���-1��

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
