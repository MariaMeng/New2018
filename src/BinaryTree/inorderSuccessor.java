package BinaryTree;

import java.util.Stack;

/**
 * Created by apple on 10/8/18.
 */
public class inorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != p) {
            stack.push(cur);
            if (cur.val > p.val)
                cur = cur.left;
            else if (cur.val < p.val)
                cur = cur.right;
        }
        if (cur.right != null) {
            stack.push(cur);
            cur = cur.right;
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else
                    return stack.pop();
            }
            return null;
        } else {
            while (!stack.isEmpty() && stack.peek().right == cur)
                cur = stack.pop();
            return stack.isEmpty() ? null : stack.pop();
        }
    }
}
