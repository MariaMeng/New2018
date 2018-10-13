package Packaging.Multiple;

import java.util.Scanner;

/**
 * Created by apple on 10/10/18.
 */
public class Coins {
    // 解法一
    public static int backPackVIII(int n, int[] value, int[] amount) {
        // write your code here
        int M = n;
        if (value == null || value.length == 0) return 0;
        n = value.length;
        int[] dp = new int[M + 1];// 前i中货币容量为j时，第i中货币剩余个数
        dp[0] = 1;

        for(int i = 1; i <= M; i++)
            dp[i] = -1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= M; j++){
                if(dp[j] >= 0)
                    dp[j] = amount[i];
                else if(j < value[i] || dp[j - value[i]] <= 0)
                    dp[j] =- 1;
                else
                    dp[j] = dp[j - value[i]] - 1;
            }
        }
        int sum = 0;
        for(int i = 1; i <= M; i++)
            if(dp[i] >= 0)
                sum++;
        return sum;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m;
        while ((n = in.nextInt())!= 0 && (m = in.nextInt()) != 0) {
            int[] value = new int[n];
            int[] amount = new int[n];

            for (int i = 0; i < n; i++)
                value[i] = in.nextInt();

            for (int i = 0; i < n; i++)
                amount[i] = in.nextInt();

            System.out.println(backPackVIII(m, value, amount));
        }
    }

}
