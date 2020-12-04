package Date.July.July292019;

/**
 * Created by apple on 7/29/19.
 */
public class Leetcode1026 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    int max = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;

        int[] data = new int[2];
        data[0] = Integer.MIN_VALUE; // 最大值
        data[1] = Integer.MAX_VALUE; // 最小值

        traverse(root, data);
        return max;
    }

    public void traverse(TreeNode root, int[] data) {
        if (root == null) return ;
        int[] left = new int[2];
        int[] right = new int[2];
        left[0] = root.val; left[1] = root.val;
        right[0] = root.val; right[1] = root.val;

        traverse(root.left, left);
        traverse(root.right, right);

        max = Math.max(max, Math.abs(root.val - left[0]));
        data[0] = Math.max(data[0], Math.max(root.val, left[0]));


        max = Math.max(max, Math.abs(root.val - left[1]));
        data[1] = Math.min(data[1], Math.min(root.val, left[1]));

        max = Math.max(max, Math.abs(root.val - right[0]));
        data[0] = Math.max(data[0], Math.max(root.val, right[0]));

        max = Math.max(max, Math.abs(root.val - right[1]));
        data[1] = Math.min(data[1], Math.min(root.val, right[1]));

    }

    public int maxAncestorDiff2(TreeNode root) {
        if (root == null) return 0;
        return traverse(root, root.val, root.val);

    }

    public int traverse(TreeNode root, int min, int max) {

        int v = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));

        if (root.left != null) {
            v = Math.max(v, traverse(root.left, Math.min(min, root.val), Math.max(max, root.val)));
        }
        if (root.right != null) {
            v = Math.max(v, traverse(root.right, Math.min(min, root.val), Math.max(max, root.val)));
        }
        return v;
    }
}
