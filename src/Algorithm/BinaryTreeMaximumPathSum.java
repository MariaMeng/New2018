package Algorithm;

/**
 * Created by apple on 9/19/18.
 *
 * ���parerent-child path sum ���Բ��������ڵ�
 * �������������ֵ�������澭���������ڵ�����ֵ
 * ���ú�������
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
