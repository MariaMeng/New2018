package ��������.���ر�������;

import java.util.Scanner;

/**
 * Created by apple on 9/30/18.
 * ����������һ���ǳ�����ļ���Ʒ���ۼ�m������������n��ֽ�ң���i��ֽ��ÿ�ű�ֵΪAi���ܹ���Bi�š�Ȼ���أ������Ǹ����������ˣ���ϣ���Ӱ����������ٵ�ֽ��ȥ֧����������Ʒ������������˼��������������Ϊ�����ѵ������������򵥵����⡣

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
}
