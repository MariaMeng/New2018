package MIOJ;

import java.util.Scanner;

/**
 * Created by apple on 12/26/18.
 */
public class RotateMiddle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        System.out.println(solution(data));
    }


    private static String solution(String line) {
        // please   write your code here
        if (line == null || line.length() == 0) return null;
        String[] str = line.split(",");
        int len = str.length;
        if (len == 0) return null;

        // find min
        int pos = helper(str, 0, len - 1);
        return str[(pos + len / 2) % len];
        // return ans;
    }

    public static int helper(String[] str, int left, int right) {
        if (left >= right)
            return left;

        int mid = left + (right - left) / 2;
        if (Integer.parseInt(str[left]) < Integer.parseInt(str[right]))
            return left;

        if (Integer.parseInt(str[left]) > Integer.parseInt(str[mid])) {
            if (Integer.parseInt(str[mid]) < Integer.parseInt(str[mid - 1]))
                return mid;
            return helper(str, left, mid - 1);
        }
        else
            return helper(str, mid + 1, right);

    }
}
