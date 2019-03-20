package Packaging.Multiple;

import java.util.Scanner;

/**
 * Created by apple on 9/30/18.
 * ����������һ���ǳ�����ļ���Ʒ���ۼ�m������������n��ֽ�ң���i��ֽ��ÿ�ű�ֵΪAi���ܹ���Bi�š�
 * Ȼ���أ������Ǹ����������ˣ���ϣ���Ӱ����������ٵ�ֽ��ȥ֧����������Ʒ��
 * ����������˼��������������Ϊ�����ѵ������������򵥵����⡣

 ����
 ��һ������������n��m����1��n��100, 1��m��1e8��

 �ڶ���n������������i������ʾ��i��ֽ�ҵ���ֵ����1��Ai��10000��

 ������n������������i������ʾ��i��ֽ�ҵ���������1��Bi��100��

 ���
 һ������������������ٵ�ֽ����������֤�������㹻��Ǯ���Թ����������Ʒ

 ��������
 3 100
 10 20 50
 1 10 1
 �������
 4
 */
public class Jinianpin {
    private static int[] dp;
    static int max = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        int W = in.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            B[i] = in.nextInt();
        }
        dp = new int[W + 1];

        int res = findMin3(A, B, W);
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
        // dp[i][j]��ʾǰi����Ʒ�з���������Ϊj�İ��У�����ֽ�ҵĸ���
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

    public static int findMin2(int[] weight, int[] limit, int maxWeight) {
        int n = weight.length;
        int m = maxWeight;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[m + 1];
        // 1. set the special case
        dp[0] = 0;
        for (int j = 1; j <= m; j++) {
            dp[j] = max;
        }
        // 2. traverse the whole process
        // dp[i][j]��ʾǰi����Ʒ�з���������Ϊj�İ��У�����ֽ�ҵĸ���
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= weight[i - 1]; j--) {
//                int nCount = Math.min(limit[i - 1], j / weight[i - 1]);
                for (int k = 0; k <= limit[i - 1]; k++) {
                    if (j - k * weight[i - 1] >= 0 && dp[j - k * weight[i - 1]] != max)
                        dp[j] = Math.min(dp[j], k + dp[j - k * weight[i - 1]]);
                }
            }
        }

        return dp[m] == max ? 0 : dp[m];
    }

    public static int findMin3(int[] weight, int[] count, int W) {
        int n = weight.length;


        dp[0] = 0;
        for (int j = 1; j <= W; j++) {
            dp[j] = max;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i - 1] * weight[i - 1] >= W) {
                completePack(weight[i - 1], 1, W,i);
            } else {
                int m = count[i - 1];
                for (int k = 1; k <= m;) {
                    zeroOnePack(k * weight[i - 1], k * 1, W,i);
                    m -= k;
                    k *= 2;
                }
                zeroOnePack(weight[i - 1] * m, 1 * m, W,i);
            }
        }
        return dp[W] == max ? 0 : dp[W];
    }

    private static void zeroOnePack(int nweight, int nvalue, int W,int i) {
        for (int j = W; j >= nweight; j--) {
            if (dp[j - nweight] != max)
                dp[j] = Math.min(dp[j - nweight] + nvalue, dp[j]);
        }
    }


    public static void completePack(int nweight, int nvalue, int W, int i) {
        for (int j = nweight; j <= W; j++) {
            if (dp[j - nweight] != max)
                dp[j] = Math.min(dp[j - nweight] + nvalue, dp[j]);
        }
    }
}
