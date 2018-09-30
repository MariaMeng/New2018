package Algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by apple on 9/25/18.
 */
public class MinimumLexico {
    public static String findminLexico(String[] data) {
        if (data == null || data.length == 0 )return null;
        Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String O1 = o1 + o2;
                String O2 = o2 + o1;
                return O1.compareTo(O2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String d : data) {
            sb.append(d);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] data = new String[n];

        for (int i = 0; i < n; i++) {
            data[i] = in.next();
        }

        System.out.println(findminLexico(data));
    }
}
