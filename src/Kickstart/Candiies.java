package Kickstart;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by apple on 7/29/18.
 */
public class Candiies {
//    public static void main(String[] args) throws Exception{
//
//        Scanner in = new Scanner(System.in);
//
//
//        String path = "outputCandy.txt";
//        File file = new File(path);
//
//        FileWriter fw = new FileWriter(file);
//
//        int n = in.nextInt();
//
//        for (int k = 1; k <= n; k++) {
//            int N = in.nextInt();
//            long[] candy = new long[N];
//            boolean[] odd = new boolean[N];
//
//            int O = in.nextInt();
//            long D = in.nextLong();
//
//            long x0 = in.nextLong();
//            long x1 = in.nextLong();
//
//            int A = in.nextInt();
//            int B = in.nextInt();
//            int C = in.nextInt();
//
//            int M = in.nextInt();
//            int L = in.nextInt();
//
//            candy[0] = x0 + L;
//            candy[1] = x1 + L;
//
//            odd[0] = (candy[0] % 2 != 0);
//            odd[1] = (candy[1] % 2 != 0);
//
//            for (int i = 2; i < N; i++) {
//                long x = (A * x1 + B * x0 + C ) % M ;
//
//                candy[i] = x + L;
//
//                if (candy[i] < 0)
//                    odd[i] = (candy[i] % 2) == -1;
//                else
//                    odd[i] = (candy[i] % 2) == 1;
//
//                x0 = x1;
//                x1 = x;
//            }
//
//            long[] res = new long[1];
//            res[0] = Long.MIN_VALUE;
//            for (int i = 0; i < N; i++) {
//                findWays(candy, odd, N, O, D, res, i);
//            }
//
//            fw.write("Case #" + k + ": " + ((res[0] != Long.MIN_VALUE) ? res[0] : "IMPOSSIBLE"));
//
//            if (k != n)
//                fw.write("\n");
//
//
//        }
//        fw.close();
//
//    }

    public static void main(String[] args) throws Exception{

        Scanner in = new Scanner(System.in);


        String path = "outputCandy.txt";
        File file = new File(path);

        FileWriter fw = new FileWriter(file);

        int n = in.nextInt();

        for (int k = 1; k <= n; k++) {
            int N = in.nextInt();
//            long[] candy = new long[N];
            boolean[] odd = new boolean[N];

            int O = in.nextInt();
            long D = in.nextLong();

            long x0 = in.nextLong();
            long x1 = in.nextLong();

            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();

            int M = in.nextInt();
            int L = in.nextInt();

            long candy[] = new long[2];
            candy[0] = x0 + L;
            candy[1] = x1 + L;

            long sum = 0;
            int oddNum = 0;

            for (int i = 0; i < 2; i++) {
                if (candy[i] % 2 == 0) {
                    if (candy[i] < D)
                        sum += candy[i];
                } else {
                    if (oddNum == 0) {
                        fw.write("Case #" + k + ": " + sum);

                        if (k != n)
                            fw.write("\n");
                        continue;
                    } else {
                        sum += candy[i];
                        oddNum++;
                    }
                }
            }


            long candy_l = 0;
            for (int i = 2; i < N; i++) {
                long x = (A * x1 + B * x0 + C ) % M ;

                candy_l = x + L;

                if (candy_l < 0)
                    odd[i] = (candy_l % 2) == -1;
                else
                    odd[i] = (candy_l % 2) == 1;

                x0 = x1;
                x1 = x;
            }





            fw.write("Case #" + k + ": " + ((sum != Long.MIN_VALUE) ? sum : "IMPOSSIBLE"));

            if (k != n)
                fw.write("\n");


        }
        fw.close();

    }

    public static void findWays(long[] C, boolean[] odd, int N, int O, long D, long[] res, int start) {

        long sum = 0;
        int oddNum = 0;
        for (int i = start; i < N; i++) {
            if (!odd[i]) {
                sum = sum + (C[i] <= 0 && i != start ? 0 : C[i]);
            } else {
                if (oddNum >= O) {
                    if (sum <= D) {
                        res[0] = Math.max(res[0], sum);
                    }
                    break;
                }

                else {
                    sum += C[i];
                    oddNum++;
                }
            }
        }

        if (sum < D) {
            res[0] = Math.max(res[0], sum);
        }
    }

}
