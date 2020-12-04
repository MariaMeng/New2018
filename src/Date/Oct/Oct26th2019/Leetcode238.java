package Date.Oct.Oct26th2019;

/**
 * Created by apple on 10/26/19.
 */
public class Leetcode238 {

    public static int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        int[] res = new int[n];

        // 计算当前每个元素左边的区域的乘积
        int k = 1;
        for (int i = 0; i < n; i++) {
            res[i] = k;
            k *= nums[i];
        }

        k = 1;
        for (int i = n - 1; i >=0; i--) {
            res[i] *= k;
            k *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        int[] res = productExceptSelf(nums);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
