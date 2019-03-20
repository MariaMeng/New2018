/**
 * Created by apple on 10/21/18.
 */
public class WiggleSort {
    public static void wiggleSort(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 2) return ;
        int n = nums.length;
        int right = nums.length - 1;

        int left = 1;
        while (nums[left] == nums[0]) {
            while (nums[right] == nums[left])
                right--;
            swap(nums, left, right);
        }
        left = 2;
        right = nums.length - 1;

        while (left < n) {
            while (nums[left] == nums[left - 1]) {
                while (nums[right] == nums[left])
                    right--;
                swap(nums, left, right);
            }
            right = nums.length - 1;
            if (nums[left - 2] > nums[left - 1] && nums[left] < nums[left - 1]) {
                swap(nums, left, left - 1);
            }
            else if (nums[left - 2] < nums[left - 1] && nums[left] > nums[left - 1]) {
                swap(nums, left, left - 1);
            }
            left++;
        }
    }
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        wiggleSort(nums);
        for (int i : nums)
            System.out.print(i + " ");
    }
}
