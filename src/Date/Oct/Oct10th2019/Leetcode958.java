package Date.Oct.Oct10th2019;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by apple on 10/10/19.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Leetcode958 {

    public boolean isCompleteTree(TreeNode root) {

        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.left == null && p.right != null) return false;
            if (isLeaf && (p.left != null || p.right != null)) return false;

            if (p.left != null) {
                queue.offer(p.left);
            }

            if (p.right != null) {
                queue.offer(p.right);
            } else {
                isLeaf = true;
            }
        }

        return true;
    }
}
