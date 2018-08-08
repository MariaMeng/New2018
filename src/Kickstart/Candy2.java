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

            long[] Sum = new long[N];
            boolean[] odd = new boolean[N];

            int x0 = in.nextInt();

            int x1 = in.nextInt();

            int A = in.nextInt();
            int B = in.nextInt();

            int C = in.nextInt();
            int M = in.nextInt();
            int L = in.nextInt();

            Sum[0] = x0 + L;
            Sum[1] = Sum[0] + x1 + L;

            for (int i = 2 ; i < N; i++) {
                int x = (A * x1 + B * x0 + C) % M;
                Sum[i] = Sum[i - 1] + x + L;

                if (Sum[i] % 2 != 0)
                    odd[i] = true;

                x1 = x;
                x1 = x0;
            }


            long res = findSum(Sum, odd, N, O, D);

            fw.write("Case #" + k + ":");
            if (k != K)
                fw.write("\n");
        }


        fw.close();
    }


    public static long findSum(long[] Sum, boolean[] Odd, int N, int O, long D) {
        if (Sum == null || Sum.length == 0) return -1;

        int left = 0, right = 0;
        int odd = 0;
        long sum = 0;

        while (left < N) {
            while (right < N && Sum[right] - Sum[left] <= D && odd < O) {
                if (Odd[right]) {
                    odd++;
                }

                right++;
            }

            if (Sum[right - 1] - Sum[left] > sum){
                sum = Sum[right - 1] - Sum[left];
            }

            if (Odd[left])
                odd--;
            left++;
        }

        return sum;
    }
}
