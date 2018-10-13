package Packaging.ZeroOne;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by apple on 10/1/18.
 * ����2546
 *
 * ���ӿƴ󱾲�ʳ�õķ�����һ�ֺܹ������ƣ����ڹ���֮ǰ�ж����������һ����Ʒ֮ǰ�����ϵ�ʣ������ڻ����5Ԫ��
 * ��һ�����Թ���ɹ�����ʹ����������Ϊ�����������޷����򣨼�ʹ����㹻�������Դ�Ҷ�ϣ������ʹ���ϵ�������١�
 ĳ�죬ʳ������n�ֲ˳��ۣ�ÿ�ֲ˿ɹ���һ�Ρ���֪ÿ�ֲ˵ļ۸��Լ����ϵ��������ٿ�ʹ���ϵ����Ϊ���١�


 Input
 �������ݡ�����ÿ�����ݣ�
 ��һ��Ϊ������n����ʾ�˵�������n<=1000��
 �ڶ��а���n������������ʾÿ�ֲ˵ļ۸񡣼۸񲻳���50��
 �����а���һ��������m����ʾ���ϵ���m<=1000��

 n=0��ʾ���ݽ�����


 Output
 ����ÿ������,���һ��,����һ����������ʾ���Ͽ��ܵ���С��


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
        int M = MaxValue - 5; // ��5Ԫ�����Ķ���

        Arrays.sort(V); // ���մ�С��������

        int max = V[n - 1]; // ������ļ۸�

        int[][] dp = new int[n + 1][M + 1];

        // ���ʣ��Ǯ����������˵Ķ�����������ܹ�������ֵ
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
