package MIOJ;

import java.util.Scanner;

/**
 * Created by apple on 3/29/19.
 */
public class Wash {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();

        int[] last = new int[n];
        byte[] num = new byte[100000];

        int po = 0;
        for (int i = 0; i < q; i++) {
            int x = in.nextInt();
            byte y = in.nextByte();
            num[x] = y;
        }
        int a = in.nextInt();

        for (int i = 0; i <= 100000; i++) {
            if (i <= a) {
                for (int j = 1; j <= num[i]; j++) {
                    last[po] = (i >= last[po] ? i + k : last[po] + k);
                    po = (po + 1) % n;
                }
            }
            if (i == a)
                break;

        }

        int res = last[po] + k;
        System.out.println(res);
    }



}
