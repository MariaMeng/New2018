package Kickstart;

import java.util.Scanner;

/**
 * Created by apple on 8/5/18.
 *
 * 找到不大于M的连续最大和子数列。
 * Given an array having N positive integers,
 * find the contiguous subarray having sum as great as possible,, but not greater than M.
 */
public class ContinuousMaximumSubarray {
    public static int[] main(int[] numbers, int ceiling) {
        if (numbers == null || numbers.length == 0) return new int[0];

        int n = numbers.length;
        int left = 0, right = 0;
        int[] acc = new int[n];
        int[] idx = new int[2];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            acc[i] = (i == 0 ? 0 : acc[i - 1]) + numbers[i];
        }


        while (left < n) {
            while (right < n && acc[right] - acc[left] <= ceiling) {
                right++;
            }
            if (acc[right - 1] - acc[left] > sum) {
                sum = acc[right - 1] - acc[left];
                idx[0] = left;
                idx[1] = right - 1;
            }
            left++;
        }

        return idx;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }

        int ceiling = in.nextInt();

        int[] result = main(data, ceiling);

        // for testing
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
