package VMware;

import java.util.Scanner;

/**
 * Created by apple on 10/16/18.
 */
public class Nsum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m;
        while (in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            double res = n, tmp = n;
            for (int i = 1; i < m; i++) {
                tmp = Math.sqrt(tmp);
                res += tmp;
            }
            System.out.println(String.format("%.2f", res));
        }
    }

}
