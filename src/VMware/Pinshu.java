package VMware;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

/**
 * Created by apple on 10/16/18.
 * 有n个正整数，请将它们拼接成一排，组成一个最大的多位整数。例如：n=3时，3个整数13，312，343拼接成的最大整数为：34331213。

 输入
 第一行为正整数个数n（n<=10000），第二行n个以空格相隔的正整数（integer类型）

 输出
 输出一行表示答案


 样例输入
 3
 13 312 343
 样例输出
 34331213

 Hint
 样例中的6种不同的拼接方案中，只有34331213是最大的，因此我们只需要输出34331213
 */
public class Pinshu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] num = new String[n];
        for (int i = 0; i < n; i++) {
            num[i] = String.valueOf(in.nextInt());
        }

        System.out.println(maxPinshu(num));
    }
    public static String maxPinshu(String[] num) {
        Arrays.sort(num, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String O1 = o1 + o2;
                String O2 = o2 + o1;
                return O2.compareTo(O1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String n : num)
            sb.append(n);
        return sb.toString();
    }

}
