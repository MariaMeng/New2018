package Yogurt;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by apple on 8/26/18.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);

        String path = "output_yg.out";
        File  file = new File(path);

        FileWriter fw = new FileWriter(file);

        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {

            int N = in.nextInt();

            int K = in.nextInt();
            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            Arrays.sort(A);

            int res = findMax(A, K);

            fw.write("Case #" + t + ": " + res);
            if (t != T) {
                fw.write("\n");
            }
        }

        fw.close();
    }

    public static int findMax(int[] A, int K) {

        int n = A.length;
        int res = 0;
        int j = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            A[i] -= j;
            if (A[i] <= 0) continue;
            k++;
            if (k == K) {
                res += K;
                j++;
                k = 0;
            }
        }

        res += k;

        return res;
    }
}
