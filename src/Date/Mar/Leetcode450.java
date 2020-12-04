package Date.Mar;

import java.util.Iterator;

/**
 * @author mengxiang
 * @date 20/3/30
 */


public class Leetcode450 {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) root = null;
            if (root.right != null) {
                TreeNode right = findLeft(root.right);
                root.val = right.val;
                root.right = deleteNode(root.right, root.val);
            } else {
                TreeNode left = findRight(root.left);
                root.val = left.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public TreeNode findLeft(TreeNode root) {
        if (root == null) return null;
        TreeNode res = findLeft(root.left);
        return res == null? root: res;
    }

    public TreeNode findRight(TreeNode root) {
        if (root == null) return null;
        TreeNode res = findRight(root.right);
        return res == null? root: res;
    }

}
