package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 动态规划 + 压缩算法
 * 参考链接：
 * https://blog.csdn.net/mrcrack/article/details/71515879
 *
 *
 *
 * Created by apple on 12/20/18.
 *
 输入
 输入分为多个部分，每个部分间使用分号";"分隔。

 第1部分为正整数D (1 \leq D \leq 10^9)D(1≤D≤10
 9
 )，表示独木桥的长度； 第2部分是2个正整数P, Q (1 \leq P \leq Q \leq 10)P,Q(1≤P≤Q≤10)，分别表示青蛙一次跳跃的最小距离，最大距离。数字间使用1个空格分隔； 第3部分是桥上石子的个数N (1 \leq N \leq 100)N(1≤N≤100)； 第4部分是NN个石子在数轴上的坐标（正整数），数字间使用1个空格分隔。

 输出
 输出只包括一个整数，表示青蛙过河最少需要踩到的石子数。

 输入样例
 18;1 3;8;3 4 5 7 11 12 13 17
 复制样例
 输出样例
 2
 */
public class FrogJump {

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
    static int maxn = 110;
    static int inf = 999999999;


    private static String solution(String line) {

        // please write your code here
        int[] a = new int[maxn];
        int[] f = new int[maxn * maxn];
        int[] stone = new int[maxn * maxn];
        for (int i = 0; i < maxn * maxn; i++)
            f[i] = inf;


        if (line == null || line.length() == 0) return null;
        String[] str = line.split(";");
        if (str == null || str.length == 0) return null;

        int l = Integer.parseInt(str[0]);
        String[] str1 = str[1].split(" ");
        int s = Integer.parseInt(str1[0]);
        int t = Integer.parseInt(str1[1]);

        int m = Integer.parseInt(str[2]);

        String[] str3 = str[3].split(" ");
        for (int i = 1; i <= m; i++) {
            a[i] = Integer.parseInt(str3[i - 1]);
        }

        int ans = 0;
        int d = 0;

        if (s == t) {
            for (int i = 1; i <= m; i++) {
                if (a[i] % s == 0)
                    ans++;
            }
            return ans + "";
        }

        // sort
        for (int i = 1 ; i <= m; i++) {
            for (int j = i + 1; j <= m; j++) {
                if (a[i] > a[j]) {
                    d = a[i];
                    a[i] = a[j];
                    a[j] = d;
                }
            }
        }

        int k = s * t;
        for (int j = 0, i = 1; i <= m; i++) {
            a[i] -= j;
            d = a[i] - a[i - 1];

            if (d > k) {
                a[i] = a[i - 1] + k;
                j += d - k;
            }
        }

        for (int i = 1; i <= m; i++) {
            stone[a[i]] = 1;
        }
        f[0] = 0;

        for (int i = 0; i <= a[m]; i++) {
            for (int j = s; j <= t; j++) {
                if (stone[i + j] == 1)
                    f[i + j] = Math.min(f[i + j], f[i] + 1);
                else
                    f[i + j] = Math.min(f[i + j], f[i]);
            }
        }

        ans = inf;
        for (int i = 1; i < t; i++) {
            ans = Math.min(ans, f[a[m] + i]);
        }
        return ans + "";

        // return ans;
    }








}
