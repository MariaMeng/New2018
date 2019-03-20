package DP;

import java.util.Scanner;

/**
 * Created by apple on 12/19/18.
 *
 * 你是一名专业劫匪，并且正在计划抢劫一条街道上的所有房子。每个房子有一定数量的现金。
 * 唯一能够阻止你的就是安保系统被触发，当有两个相邻的房子在同一晚被劫时，安保系统才会自动触发。
 * 现在给你一个正整数数组表示每家现金数，请求出这一晚你能在不触发安保系统时抢到的最大金额。
 *
 *
 * 输入
 由逗号(,)分隔的一串正整数，表示这一条街上每个房子内的现金数。

 输出
 一个正整数，表示你能抢到的最大金额。

 输入样例
 1,2

 输出样例
 2

 */
public class Robbery {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        System.out.println(solution(str));
    }


    /**
     * 已引入：
     * java.util.*
     * 要使用其他 jar 包请使用完整路径，如：
     * java.util.List<java.util.List<Integer>> list = new java.util.ArrayList<java.util.List<Integer>>(100);
     * @param  line 为单行测试数据
     * @return 处理后的结果
     */
    private static String solution(String line) {
        // please write your code here
        if (line == null || line.length() == 0) return null;

        String[] str = line.split(",");
        if (str == null || str.length == 0) return null;

        int n = str.length;

        int first = 0;
        int second = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num  = Integer.parseInt(str[i]);
            max = Math.max(first, num + second);

            second = first;
            first = max;
        }

        return max + "";
        // return ans;
    }
}
