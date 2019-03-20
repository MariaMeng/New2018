package MIOJ;

import Packaging.Multiple.Packing;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by apple on 12/28/18.
 *
 * 给定一个只包含小写字母的字符串，现在我 mi 被众友商品牌的字符串围困在其中，需要我们将字符串中的 mi 全部移除然后输出，保证最后输出的字符串中没有 "mi"。

 输入
 一行数据包含一个字符串，长度 <= 100000，字符串仅包含小写字母。

 输出
 输出处理后的字符串

 输入样例
 huaweimivivo
 chuizimmmiioppo
 samsungmimiapple
 复制样例
 输出样例
 huaweivivo
 chuizimoppo
 samsungapple
 */
public class SaveMI {

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
        if (line == null || line.length() == 0) {
            return null;
        }
        line = line.trim();

        Deque<Character> deque = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'i' && !deque.isEmpty() && deque.peekLast() == 'm') {
                deque.pollLast();
            } else {
                deque.offerLast(line.charAt(i));
            }
        }

        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pollFirst());
        }

        return stringBuilder.toString();
        // return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(solution(in.nextLine()));
    }
}
