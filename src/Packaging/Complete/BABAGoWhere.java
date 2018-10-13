package Packaging.Complete;

import java.util.Scanner;

/**
 * Created by apple on 17/3/29.
 * 小鱼儿和安吉一起去参加爸爸去哪儿，村长交给他们一项任务，是用老乡的水果去给爸爸兑换一个礼物，要求水果和礼物等价，不能多也不能少。
 * 假设老乡有n种水果，每种水果的数量不限，每种水果的价值不同。请帮小鱼儿和安吉计算出他们最少要和老乡要几个水果。如果无法兑换返回-1.
 举例：
 1.有3种水果，价值分别是5，2，3。礼物的价值是20.用4个5元的水果正好兑换，其他的兑换方法都要更多的水果，所以返回4
 2.有两种水果，价值分别是5,3，礼物的价值是2.无法正好兑换，所以返回-1

 输入
 输入数据是一个数组和一个整数代表礼物价值

 输出
 对于每个测试实例，要求输出最少水果数


 样例输入
 5,2,3
 20

 样例输出
 4

 * 测试样例中给定了一个数组包括了每种商品重量， 每种商品可以多次拿取。
 * 还给了一个背包的最大的承重能力
 * 输出：最少的物品个数
 * 注意事项：
 * 这道题因为求解最小的数值
 * 所以不可达点 设置为 Integer.MAX_VALUE
 */
public class BABAGoWhere {
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        String[] str = reader.next().split(",");
        int[] array = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        int y = reader.nextInt();
        System.out.println(minCoins(array,y));


    }

    public static int minCoins_B(int[] arr, int aim) {
        if(arr == null || arr.length == 0 || aim < 0){
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] f = new int[aim + 1];
        for(int i = 1; i < f.length; i++){
            f[i] = max;
        }
        for(int i = 0; i < n; i++){
            for(int j = arr[i]; j < f.length; j++){
                if (f[j - arr[i]] != max) {
                    f[j] = Math.min(f[j], f[j - arr[i]] + 1);
                }

            }
        }
        return f[aim];
    }

    public static int minCoins(int[] arr,int aim){
        if(arr==null||arr.length==0||aim<0){
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim+1];

        for(int j = 1;j <= aim;j++){
            // 在j的承重下，第一种物品，，掐能把包装满的最少的样品个数
            dp[0][j] = max;
            // 如果当前重量小于J,并且上一个状态的最少个数不是
            if(j - arr[0] >= 0 && dp[0][j - arr[0]] != max){
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }

        int left = 0;
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= aim; j++){
                left = max;
                if(j - arr[i] >= 0 && dp[i][j - arr[i]] != max){
                    // 这里因为可以取多次值，所以如果当次取值，则问题转化为前i种物品在剩余空间为j - arr[i]情况下的最少的个数
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }

}
