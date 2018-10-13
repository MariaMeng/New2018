package Packaging.Complete;

import java.util.Scanner;

/**
 * Created by apple on 10/1/18.
 * ����1114
 *
 * Before ACM can do anything, a budget must be prepared and the necessary financial support obtained.
 * The main income for this action comes from Irreversibly Bound Money (IBM). The idea behind is simple.
 * Whenever some ACM member has any small money, he takes all the coins and throws them into a piggy-bank.
 * You know that this process is irreversible, the coins cannot be removed without breaking the pig.
 * After a sufficiently long time, there should be enough cash in the piggy-bank to pay everything that needs to be paid.

 But there is a big problem with piggy-banks. It is not possible to determine how much money is inside.
 So we might break the pig into pieces only to find out that there is not enough money. Clearly, we want to avoid this unpleasant situation.
 The only possibility is to weigh the piggy-bank and try to guess how many coins are inside.
 Assume that we are able to determine the weight of the pig exactly and that we know the weights of all coins of a given currency.
 Then there is some minimum amount of money in the piggy-bank that we can guarantee.
 Your task is to find out this worst case and determine the minimum amount of cash inside the piggy-bank.
 We need your help. No more prematurely broken pigs!


 Input
 The input consists of T test cases. The number of them (T) is given on the first line of the input file.
 Each test case begins with a line containing two integers E and F.
 They indicate the weight of an empty pig and of the pig filled with coins. Both weights are given in grams.
 No pig will weigh more than 10 kg, that means 1 <= E <= F <= 10000. On the second line of each test case,
 there is an integer number N (1 <= N <= 500) that gives the number of various coins used in the given currency.
 Following this are exactly N lines, each specifying one coin type.
 These lines contain two integers each, Pand W (1 <= P <= 50000, 1 <= W <=10000).
 P is the value of the coin in monetary units, W is it's weight in grams.


 Output
 Print exactly one line of output for each test case.
 The line must contain the sentence "The minimum amount of money in the piggy-bank is X."
 where X is the minimum amount of money that can be achieved using coins with the given total weight.
 If the weight cannot be reached exactly, print a line "This is impossible.".


 Sample Input

 3
 10 110
 2
 1 1
 30 50
 10 110
 2
 1 1
 50 30
 1 6
 2
 10 3
 20 4



 Sample Output

 The minimum amount of money in the piggy-bank is 60.
 The minimum amount of money in the piggy-bank is 100.
 This is impossible.
 */
public class PiggyBank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        for (int k = 0; k < K; k++) {
            int Pure = in.nextInt();
            int Full = in.nextInt();
            int MaxWeight = Full - Pure;

            int n = in.nextInt();
            int[] P = new int[n];
            int[] W = new int[n];
            for (int i = 0; i < n; i++) {
                P[i] = in.nextInt();
                W[i] = in.nextInt();
            }

            int res = findMinValue(P, W, MaxWeight);
            System.out.println((res == Integer.MAX_VALUE ? "This is impossible." : "The minimum amount of money in the piggy-bank is " + res + "."));
        }
    }

    public static int findMinValue(int[] P, int[] W, int MaxWeight) {
        if (P.length == 0 || W.length == 0) return Integer.MAX_VALUE;
        int n = P.length;
        int M = MaxWeight;
        int[][] dp = new int[n + 1][M + 1];
        int max = Integer.MAX_VALUE;

        for (int i = 1; i <= M; i++) {
            dp[0][i] = max;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= M; j++) {
                int left = max;
                if (j - W[i - 1] >= 0 && dp[i][j - W[i - 1]] != max) {
                    left = P[i - 1] + dp[i][j - W[i - 1]];
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[n][M];
    }

}
