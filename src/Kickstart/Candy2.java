package Kickstart;

import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by apple on 8/2/18.
 *
 * Xi = (A * Xi-1 + B * Xi-2 + C) mod M, i = 3to N
 * Si = Xi + L, for i =1 to N
 *
 * N, O, D
 * X1, X2, A B C M L
 *
 */
public class Candy2 {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);

        String path = "ouput_candy.txt";

        FileWriter fw = new FileWriter(path);

        int K = in.nextInt();

        for (int k = 1; k <= K; k++) {

            int N = in.nextInt();
            int O = in.nextInt();
            long D = in.nextLong();

            long[] SS = new long[N];
            int[] SO = new int[N];

            long x0 = in.nextLong();

            long x1 = in.nextLong();

            int A = in.nextInt();
            int B = in.nextInt();

            int C = in.nextInt();
            int M = in.nextInt();
            int L = in.nextInt();

            SS[0] = x0 + L;
            SO[0] = (x0 % 2 == 0 ? 0 : 1);
            SS[1] = SS[0] + x1 + L;
            SO[1] = SO[0] + (x1 % 2 == 0 ? 0 : 1);

            for (int i = 2 ; i < N; i++) {
                long x = (A * x1 + B * x0 + C) % M;
                SS[i] = SS[i - 1] + x + L;
                SO[i] = SO[i - 1] + (x % 2 == 0 ? 0 : 1);

                x0 = x1;
                x1 = x;
            }


            long res = findSum(SS, SO, N, O, D);

            fw.write("Case #" + k + ":" + (res == Long.MIN_VALUE ? "IMPOSSIBLE" : res));
            if (k != K)
                fw.write("\n");
        }

        fw.close();
    }


    public static long findSum(long[] SS, int[] SO, int N, int O, long D) {
        if (SS == null || SO == null || SS.length == 0|| SO.length == 0) return Long.MIN_VALUE;

        int left = 0, right = 1;
        long sum = Long.MIN_VALUE;

        while (left < N) {
            while (right < N && SO[right] - SO[left] <= O && SS[right] - SS[left] <= D ) {
                right++;
            }


            if (right - 1 > left)
                sum = Math.max(sum, SS[right - 1] - SS[left]);

            left++;
            if (right - 1 > left - 1)
                right = left + 1;
        }

        return sum;
    }
}
