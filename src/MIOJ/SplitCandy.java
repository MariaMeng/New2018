package MIOJ;

import java.util.Scanner;

/**
 * Created by apple on 1/8/19.
 */
public class SplitCandy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(solution(in.nextLine()));
    }

    public static String solution(String line) {
        if (line == null || line.length() == 0) return null;
        String[] str = line.split(",");
        int len = str.length;
        if (len == 0) return null;

        int M = Integer.parseInt(str[0]); // 糖果个数
        int N = Integer.parseInt(str[1]); // 篮子个数

        int res = helper(M, N, 0, 0, 0);
        return String.valueOf(res);
    }

    public static int helper(int M, int N, int pos, int val, int sum) {
        if (pos == N - 1) return 1;
        int res = 0;

        for (int i = val; i < M; i++) {
            if (M - i - sum < i) break;
            if (pos < N - 2)
                res += helper(M, N, pos + 1, i, sum + i);
            else
                res += helper(M, N, pos + 1, M - sum - i, sum + i);
        }
        return res;
    }
}
