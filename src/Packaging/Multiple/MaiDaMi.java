package Packaging.Multiple;

import java.util.Scanner;

/**
 * Created by apple on 9/30/18.
 * ����2191
 *
 * Input
 �����������Ȱ���һ��������C����ʾ��C�����������ÿ����������ĵ�һ������������n��m(1<=n<=100, 1<=m<=100),�ֱ��ʾ���ѵĽ��ʹ��׵����࣬Ȼ����m�����ݣ�ÿ�а���3����p��h��c(1<=p<=20,1<=h<=200,1<=c<=20)���ֱ��ʾÿ���ļ۸�ÿ���������Լ���Ӧ������׵Ĵ�����


 Output
 ����ÿ��������ݣ�������ܹ�������׵��������������Լ��辭���򲻹����еĴ��ף����Ҿ�������Բ����ꡣÿ��ʵ�������ռһ�С�


 Sample Input

 1
 8 2
 2 100 4
 4 100 2



 Sample Output

 400
 */
public class MaiDaMi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int K = in.nextInt();
        for (int k = 0; k < K; k++) {
            int M = in.nextInt();
            int n = in.nextInt();
            int[] P = new int[n];
            int[] H = new int[n];
            int[] C = new int[n];

            for (int i = 0; i < n; i++) {
                P[i] = in.nextInt();
                H[i] = in.nextInt();
                C[i] = in.nextInt();
            }

            int res = findMaxWeight(P, H, C, M);
            System.out.println(res);
        }

    }
    public static int findMaxWeight(int[] P, int[] H, int[] C, int M) {
        if (P.length == 0 || H.length == 0 || C.length == 0) return -1;

        int n = P.length;
        int[][] dp = new int[n + 1][M + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= M; j++) {

                int nCount = Math.min(C[i  - 1], j / P[i - 1]);

                for (int k = 0; k <= nCount; k++) {
                    dp[i][j] = Math.max(dp[i][j], k * H[i - 1] + dp[i - 1][j - k * P[i - 1]]);
                }
            }
        }
        return dp[n][M];
    }

}
