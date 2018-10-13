package Packaging.ZeroOne;

import java.util.Scanner;

/**
 * Created by apple on 10/1/18.
 *
 * º¼µç2092
 * Many years ago , in Teddy¡¯s hometown there was a man who was called ¡°Bone Collector¡±.
 * This man like to collect varies of bones , such as dog¡¯s , cow¡¯s , also he went to the grave ¡­
 The bone collector had a big bag with a volume of V ,and along his trip of collecting there are a lot of bones ,
 obviously , different bone has different value and different volume, now given the each bone¡¯s value along his trip ,
 can you calculate out the maximum of the total value the bone collector can get ?



 Input
 The first line contain a integer T , the number of cases.
 Followed by T cases , each case three lines ,
 the first line contain two integer N , V, (N <= 1000 , V <= 1000 )representing the number of bones and the volume of his bag.
 And the second line contain N integers representing the value of each bone. T
 he third line contain N integers representing the volume of each bone.


 Output
 One integer per line representing the maximum of the total value (this number will be less than 231).


 Sample Input

 1
 5 10
 1 2 3 4 5
 5 4 3 2 1



 Sample Output

 14


 */
public class BoneCollector {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();

        for (int k = 0; k < K; k++) {
            int N = in.nextInt();
            int MaxWeight = in.nextInt();

            int[] V = new int[N];
            int[] W = new int[N];

            for (int i = 0; i < N; i++) {
                V[i] = in.nextInt();
            }
            for (int i = 0; i < N; i++)
                W[i] = in.nextInt();

            int res = findMaxValue(V, W, MaxWeight);
            System.out.println(res);
        }
    }

    public static int findMaxValue(int[] V, int[] W, int MaxWeight) {
        if (V.length == 0 || W.length == 0) return Integer.MAX_VALUE;

        int n = V.length;
        int M = MaxWeight;

        int[][] dp = new int[n + 1][M + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                if (j - W[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], V[i - 1] + dp[i - 1][j - W[i - 1]]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][M];
    }
}
