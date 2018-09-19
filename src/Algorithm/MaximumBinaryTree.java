package Algorithm;

import java.util.Scanner;

/**
 * Created by apple on 9/19/18.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MaximumBinaryTree {


    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return dfs(nums, 0, nums.length - 1);
    }

    public static TreeNode dfs(int[] nums, int left, int right) {
        if (left == right) return new TreeNode(nums[left]);
        if (left > right) return null;

        int max = Integer.MIN_VALUE;
        int idx = 0;

        for (int i = left; i <= right; i++) {
            if (max < nums[i]){
                max = nums[i];
                idx = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = dfs(nums, left, idx - 1);
        root.right = dfs(nums, idx + 1, right);
        return root;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        TreeNode res = constructMaximumBinaryTree(num);
        System.out.println(res);
    }
}
