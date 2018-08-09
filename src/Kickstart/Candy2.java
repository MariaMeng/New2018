package Kickstart;

import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by apple on 8/2/18.
 *
 *  Xi = (A * Xi-1 + B * Xi - 2 + C) mod M, for i = 3 to N
 *  Si = Xi + L, for i = 1 to N.
 *  input order:
 *      N, O, D
 *      X1, X2, A, B, C, M ,L
 *      D: long
 *      N, O, int
 *      Xi : long
 */
public class Candy2 {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);

        String path = "output_candy.txt";

        FileWriter fw = new FileWriter(path);

        int K = in.nextInt();

        for (int k = 1; k <= K; k++) {

           int N = in.nextInt();
           long[] SS = new long[N];
           int[] SO = new int[N];

           int O = in.nextInt();
           long D = in.nextLong();

           long x0 = in.nextLong();
           long x1 = in.nextLong();

           int A = in.nextInt();
           int B = in.nextInt();
           int C = in.nextInt();

           int M = in.nextInt();
           int L = in.nextInt();

           SS[0] = x0 + L;
           SS[1] = SS[0] + x1 + L;
           SO[0] = (x0 % 2 == 0 ? 0 : 1);
           SO[1] = SO[0] + (x1 % 2 == 0 ? 0 : 1);

           for (int j = 2; j < N; j++) {
               long X = (A * x1 + B * x0 + C) % M;
               SS[j] = SS[j  - 1] +  X + L;
               SO[j] = SO[j - 1] + (X % 2 == 0 ? 0 : 1);

               x0 = x1;
               x1 = X;
           }

           long res = findSum(SS, SO, N, O, D);

           fw.write("Case #" + k + ": " + (res == Long.MIN_VALUE ? "IMPOSSIBLE" : res));
           if (k != K)
               fw.write("\n");
        }

        fw.close();

    }

    public static long findSum(long[] SS, int[] SO, int N, int O, long D) {
        if (SS == null || SO == null || SS.length == 0 || SO.length == 0) return Long.MIN_VALUE;

        int left = 0, right = 0;
        long sum  = Long.MIN_VALUE;

        while (left < N) {
            while (right < N && SO[right] - SO[left] <= O && SS[right] - SS[left] <= D ) {
                right++;
            }
            if (SS[right - 1] - SS[left] > sum)
                sum = SS[right - 1] - SS[left];
            left++;
        }

        return sum;
    }
}
