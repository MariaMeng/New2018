package Google;

import java.io.FileWriter;
import java.util.*;
import java.io.*;

/**
 * Created by apple on 10/21/18.
 */
public class CombiningClasses {
    public static void main(String[] args ) throws Exception{
        Scanner in = new Scanner(System.in);
        String path = "out2.txt";
        File file = new File(path);
        FileWriter fw = new FileWriter(file);

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int Q = in.nextInt();
            int X1 = in.nextInt();
            int X2 = in.nextInt();
            int A1 = in.nextInt();
            int B1 = in.nextInt();
            int C1 = in.nextInt();
            int M1 = in.nextInt();

            int Y1 = in.nextInt();
            int Y2 = in.nextInt();
            int A2 = in.nextInt();
            int B2 = in.nextInt();
            int C2 = in.nextInt();
            int M2 = in.nextInt();

            int Z1 = in.nextInt();
            int Z2 = in.nextInt();
            int A3 = in.nextInt();
            int B3 = in.nextInt();
            int C3 = in.nextInt();
            int M3 = in.nextInt();

            int[] X = new int[N];
            int[] Y = new int[N];
            int[] L = new int[N];
            int[] R = new int[N];
            int Z = (A3 * Z2 + B3 * Z1 + C3) / M3;

            X[0] = X1;
            X[1] = X2;
            Y[0] = Y1;
            Y[1] = Y2;

            L[0] = Math.min(X[0], Y[0]) + 1;
            L[1] = Math.min(X[1], Y[1]) + 1;

            R[0] = Math.max(X[0], Y[0]) + 1;
            R[1] = Math.max(X[1], Y[1]) + 1;

            for (int i = 3; i <= N; i++) {
                X[i - 1] = (A1 * X2 + B1 * X1 + C1) % M1;
                Y[i - 1] = (A2 * Y2 + B2 * Y1 + C2) % M2;

                L[i - 1] = Math.min(X[i - 1], Y[i - 1]) + 1;
                R[i - 1] = Math.max(X[i - 1], Y[i - 1]) + 1;

                X1 = X2;
                X2 = X[i - 1];

                Y1 = Y2;
                Y2 = Y[i - 1];
            }
            int K = Z + 1;

            int Lmin = Integer.MAX_VALUE;
            int Rmax = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                Lmin = Math.min(Lmin, L[i]);
                Rmax = Math.max(Rmax, R[i]);
            }


            int[] map = new int[Rmax - Lmin + 1];
            for (int i = 0; i < N; i++) {
                for (int j = L[i]; j <= R[i]; j++) {
                    map[j - Lmin]++;
                }
            }
            int res = 0;
            for (int i = map.length - 1; i >= 0; i--) {
                if (map[i] == 0) continue;
                if (K <= map[i]) {
                    res = i + Lmin;
                    break;
                } else {
                    K -= map[i];
                }
            }

            fw.write("Case #" + t + ": " + res);
            if (t != T) {
                fw.write("\n");
            }

        }
        fw.close();
    }
}
