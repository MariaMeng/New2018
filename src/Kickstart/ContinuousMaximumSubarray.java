package Kickstart;

/**
 * Created by apple on 8/5/18.
 *
 *
 * Given an array having N positive integers,
 * find the contiguous subarray having sum as great as possible,, but not greater than M.
 */
public class ContinuousMaximumSubarray {
    /**
     * [1, 0, 2, 0, 4, 3, 5] ceiling=3
     * sum array:
     * [1, 1, 3, 3, 7, 10, 15]
     * @param numbers
     * @param ceiling
     * @return
     */
    public int[] main(int[] numbers, int ceiling) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        int n = numbers.length;
        int[] acc = new int[n];

        int max = 0;
        int[] idx = new int[2];

        for (int i = 0; i < n; i++) {
            acc[i] += (i == 0 ? 0 :acc[i - 1]) + numbers[i];
        }

        int left = 0, right = 0;

        while (right < n && left < right) {
            while (right < n && acc[right] - acc[left] <= ceiling) {
                right++;
            }
            if (acc[right - 1] - acc[left] > max) {
                max = acc[right - 1] - acc[left];
                idx[0] = left;
                idx[1] = right;
            }

            left++;
        }

        return idx;


    }


    public static void main(String[] args) {

    }
}
