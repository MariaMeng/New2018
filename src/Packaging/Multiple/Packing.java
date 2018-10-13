package Packaging.Multiple;

import java.util.Scanner;

/**
 * Created by apple on 9/30/18.
 * ��N����Ʒ��ÿ����Ʒ������ΪC1��C2......Cn��������ѡ���ɼ���������ΪW�ı����ÿ����Ʒ�����ΪW1��W2......Wn��WiΪ��������
 * ��֮���Ӧ�ļ�ֵΪP1,P2......Pn��PiΪ���������󱳰��ܹ����ɵ�����ֵ��
 Input

 ��1�У�2��������N��W�м��ÿո������NΪ��Ʒ�����࣬WΪ������������(1 <= N <= 100��1 <= W <= 50000)
 ��2 - N + 1�У�ÿ��3��������Wi��Pi��Ci�ֱ�����Ʒ�������ֵ��������(1 <= Wi, Pi <= 10000�� 1 <= Ci <= 200)

 Output

 ����������ɵ�����ֵ��

 Inputʾ��

 3 6
 2 2 5
 3 3 8
 1 4 1

 Outputʾ��

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
