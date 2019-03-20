package VMware;

import java.util.Scanner;

/**
 * Created by apple on 10/16/18.
 */
public class WaterFlower {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            boolean flag = false;
            for (int k = m; k <= n; k++) {
                int g = k % 10;
                int s = (k / 10) % 10;
                int b = (k / 100) % 10;
                if (g * g * g + s * s * s + b * b * b == k) {
                    System.out.print(k + " ");
                    flag = true;
                }
            }
            if (flag)
                System.out.println();
            else
                System.out.println("no");
        }
    }
}
