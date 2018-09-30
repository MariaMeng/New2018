package Algorithm;

/**
 * Created by apple on 9/19/18.
 *
 * 最大parerent-child path sum 可以不经过根节点
 * 保存子树的最大值，并保存经过子树根节点的最大值
 * 采用后续遍历
 */


public class BinaryTreeMaximumPathSum {
    public static int maxPathSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;

        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;

        dfs(root, res);

        return res[0];
    }

    public static int dfs(TreeNode root, int[] res) {
        if (root == null) return 0;

        int left = dfs(root.left, res);
        int right = dfs(root.right, res);

        int max = root.val + Math.max(left, right);
        max = Math.max(max, root.val);

        int tmp = Math.max(root.val + left + right, max);
        res[0] = Math.max(res[0], tmp);

        return max;
    }

    public static void main(String[] args) {

    }
}
