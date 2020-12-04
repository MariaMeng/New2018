package Date.Dec.Dec7th2019;

import java.util.Random;

/**
 * Created by apple on 12/7/19.
 */
public class Leetcode215 {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];

        Random random = new Random();
        int piv_idx = left + random.nextInt(right - left);
        piv_idx = partition(nums, left, right, piv_idx);

        if (piv_idx == k) return nums[k];

        if (piv_idx < k) {
            return quickSort(nums, piv_idx + 1, right, k);
        } else {
            return quickSort(nums, left, piv_idx - 1, k);
        }
    }

    public int partition(int[] nums, int left, int right, int piv_idx) {
        if (left == right) return nums[left];
        int piv = nums[piv_idx];
        swap(nums, piv_idx, right);

        int l = left, r = right - 1;
        while (l < r) {
            while (l < r && nums[l] < piv) l++;
            while (l < r && nums[r] >= piv) r--;

            if (l < r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        swap(nums, right, l);
        return l;
    }

    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {12, 3, 107, 22, 107, -rr2, 99, 109};
        int[] nums = new int[] {3, 2, 1, 5, 6, 4};
        Leetcode215 l = new Leetcode215();
        int res = l.findKthLargest(nums, 2);
        System.out.println(res);
    }
}
