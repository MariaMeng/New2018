package Test;

import java.util.Scanner;

/**
 * Created by apple on 9/30/18.
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

 Hint
 第一组：从1月2日至1月31日，31-2=29（天）
 第二组：从12月30日至第二年1月15日，31-30+15=16（天）
 */
public class SuanNinfen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int Y = in.nextInt();
            int M = in.nextInt();
            int D = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();

//            int res = findDays(Y, M, D, A, B);
//            System.out.println(res);
        }
    }

//    public static int findDays(int Y, int M, int D, int A, int B) {
//        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30,31, 30, 31};
//        if (M == A && D <= B )
//            return B - D;
//        if (M < A) {
//
//            int sum = 0;
//            sum += days[M] - D + B;
//            for (int i = M + 1; i < A; i++) {
//                if (i == 2 && Y % 4 == 0)
//                    sum += days[i] + 1;
//                else
//                    sum += days[i];
//            }
//
//            return sum;
//        } else {
//
//        }
//    }
}
