package MIOJ;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by apple on 12/25/18.
 */
public class FindMax {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
    }

    private static String solution(String line) {
        // please write your code here
        if (line == null || line.length() == 0) return null;
        String[] str = line.split(" ");
        int len = str.length;
        if (len == 0 || len % 4 != 0) return null;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int len1 = len / 4;
        for (int i = 0; i < len1; i++) {
            int start = Integer.parseInt(str[i * 4 + 1]);
            int end = Integer.parseInt(str[i * 4 + 2]);
            int val = Integer.parseInt(str[i * 4 + 3]);

            map.put(start, map.getOrDefault(start, 0) + val);
            map.put(end, map.getOrDefault(end, 0) - val);
        }

        int max = Integer.MIN_VALUE, sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            max = Math.max(max, sum);
        }

        return String.valueOf(max);
        // return ans;
    }
}
