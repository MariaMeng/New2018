package Date.Nov.Nov3rd2019;

/**
 * Created by apple on 11/3/19.
 */
public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        int minIdx = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) continue;
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
                i--;
            } else if (i > 0){
                minIdx = Math.min(minIdx, i);
            }
        }
        return minIdx == Integer.MAX_VALUE? nums.length: minIdx;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
