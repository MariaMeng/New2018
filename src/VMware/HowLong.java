package VMware;

import java.util.Scanner;

/**
 * Created by apple on 10/16/18.
 * 西西是个十足的拖延症患者，再过一段时间他就要期末考试了，但他不想复习，还想拖延下去。今天是Y年M月D日，A月B日就是考试日期，他想知道还有多少天。

 输入
 第一行一个数T，表示数据组数。（1≤T≤100）

 接下来T行，共五个正整数，Y，M，D，A，B，保证为合法日期，且(M, D)≠(A, B)，即肯定不会为同一天。（1≤Y≤10000）

 输出
 共T行，每行一个整数，如果A月B日在M月D日的前面，则输出Y年M月D日到Y+1年A月B日还有几天，否则输出Y年M月D日到Y年A月B日还有几天。（具体可参考样例）


 样例输入
 5
 2016 1 2 1 31
 2016 12 30 1 15
 2017 7 1 9 1
 2018 6 6 5 5
 2019 5 1 4 30

 样例输出
 29
 16
 62
 333
 365
 */
public class HowLong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int k = 0; k < T; k++) {
            int Y = in.nextInt();
            int M = in.nextInt();
            int D = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();
            System.out.println(findDays(Y, M, D, A, B));
        }

    }
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }
    public static int findDays(int Y, int M, int D, int A, int B) {
        int[] day = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (M  == A && D <= B)
            return B - D;
        if (M < A) {
            int res = day[M] - D + B + (M == 2 && isLeapYear(Y) ? 1 : 0);
            for (int i = M + 1; i < A; i++) {
                res += day[i];
                if (i == 2 && isLeapYear(Y))
                    res += 1;
            }
            return res;
        }
        else {
            int res = day[M] - D + B + (M == 2 && isLeapYear(Y) ? 1 : 0);
            for (int i = M + 1; i <= 12; i++) {
                res += day[i];
                if (i == 2 && isLeapYear(Y))
                    res += 1;
            }
            for (int i = 1; i < A; i++) {
                res += day[i];
                if (i == 2 && isLeapYear(Y + 1))
                    res += 1;
            }
            return res;
        }
    }

}
