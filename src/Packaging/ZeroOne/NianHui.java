package Packaging.ZeroOne;

import java.util.Scanner;

/**
 * Created by apple on 17/3/29.
 * 01背包问题
 *
 * 年会游戏
 时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 65536KB；其他语言 589824KB
 题目描述：
 公司年会设计了一个游戏，抽到号码的员工可以到舞台的桌子上带回总重量不超过固定重量的若干个奖品，桌子上的奖品数量是有限的，
 每个奖品上都标明了它的重量和价值，对于一个奖品它只能选择带走或者不带走，不能将它掰成几份带走部分，
 请设计实现一个算法计算当奖品数量、奖品价值、能带走的总重量取不同值时，员工能带走的最大价值是多少。

 输入
 输入奖品数量，每个奖品的价值和重量，能够带走的奖品重量限度
 输入第一行：奖品数量
 输入第二行：每个奖品的价值，通过空格分割
 输入第三行：每个奖品的重量，通过空格分割
 输入第四行：能够带走的奖品总重量限度

 输出
 员工能够带走的最大价值


 样例输入
 5
 5000 4000 3000 500 200
 5 4 6 3 1
 10

 样例输出
 9200
 */
public class NianHui {


    public static void main(String[] args) {
        // 1. get the input
        Scanner my = new Scanner(System.in);
        int numbers = my.nextInt();
        int[] price = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            price[i] = my.nextInt();
        }
        int[] weight = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            weight[i] = my.nextInt();
        }
        int maxWeight = my.nextInt();

        // 2. obtain from the backpack problem
        int maxPrice = findPrice(price, weight, maxWeight);
        System.out.println(maxPrice);
    }
    private static int findPrice(int[] price, int[] weight, int maxWeight){
        int n = weight.length;
        int m = maxWeight;
        int[][] dp = new int[n + 1][m + 1];
        // 1. set the special case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        // 2. traverse the whole process
        // dp[i][j]表示前i个物品中放在最大承重为j的包中，最大的价值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 如果第i个物品的重量小于等于承重j，则第i个物品可以选择放或者不放（0/1问题）
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }
                // 如果第i个物品的重量超过了承重j，则第i个物品肯定不放
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }
}
