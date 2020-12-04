package Date.Aug.Aug1st2019;

/**
 * Created by apple on 8/1/19.
 */
public class Leetcode968 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;

        int[] dp = traverse(root);

        return Math.min(dp[1], dp[2]);
    }

    public int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0, 99999};
        }

        // postOrder traverse
        int[] L = traverse(root.left);
        int[] R = traverse(root.right);

        // find the optimal solution for left-subtree
        int mL12 = Math.min(L[1], L[2]);
        // find the optimal solution for right-subtree
        int mR12 = Math.min(R[1], R[2]);

        // 状态0, 当前节点没有被覆盖，左子树右子树均被覆盖，则左子树和右子树 必为状态1
        int d0 =  L[1] + R[1];

        // 状态1, 当前节点被覆盖，无相机，左子树右子树被覆盖。则左右子树，至少有一个为状态1，另一个为状态1或者状态2
        int d1 = Math.min(L[2] + mR12, R[2] + mL12);

        // 状态2，当前节点被覆盖，有相机。左右子树为任意状态
        int d2 = 1 + Math.min(L[0], mL12) + Math.min(R[0], mR12);

        return new int[]{d0, d1, d2};
    }
}
