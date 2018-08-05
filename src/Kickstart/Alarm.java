package Kickstart;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * 注意事项：
 * Input

 2
 2 3 1 2 1 2 1 1 9
 10 10 10001 10002 10003 10004 10005 10006 89273

 Each test case consists of one line with nine integers N, K, x1, y1, C, D, E1, E2 and F.

 Output

 Case #1: 52
 Case #2: 739786670
 */

public class Alarm {
    public static void main(String[] args) throws  Exception{
        Scanner in = new Scanner(System.in);


        String path = "outputA.txt";
        File file = new File(path);

        FileWriter fw = new FileWriter(file);

        int n = in.nextInt();

        for (int k = 1; k <= n; ++k) {
            int N = in.nextInt();
            int[] A = new int[N];
            int K = in.nextInt();

            int x = in.nextInt();
            int y = in.nextInt();

            int C = in.nextInt();
            int D = in.nextInt();

            int E1 = in.nextInt();
            int E2 = in.nextInt();

            int F = in.nextInt();

            A[0] = (x + y) % F;
            int x_n  = 0, y_n = 0;
            for (int i = 1; i < N; i++) {
                x_n = (C * x + D * y + E1) % F;
                y_n = (D * x + C * y + E2) % F;

                A[i] = (x_n + y_n) % F;

                x = x_n;
                y = y_n;
            }


            int[] res = new int[1];

            for (int a = 1; a <= K; a++)
                for (int i = 0; i < N; i++) {
                    findSum(A, res, a, i, N);
                }



            fw.write("Case #" + k + ": " + res[0]  );

            if (k != n)
                fw.write("\n");


        }
        fw.close();

    }

    public static void findSum(int[] A, int[] res, int k, int start, int N) {
        if (A == null || A.length == 0) return ;

        int sum = 0;
        int tmp = 0;

        for (int i = start, j = 1; i < N; i++, j++) {
            tmp += A[i] * (int)Math.pow(j, k);
            sum += tmp;
        }

        res[0] = (res[0] + sum) % ((int)Math.pow(10, 9) + 7);
    }
}
