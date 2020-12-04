package Date.July.July282019;

import java.util.List;
import java.util.Stack;

/**
 * Created by apple on 7/28/19.
 * 二叉树的前序遍历
 * 递归方式和 非递归方式
 */
public class PreOrderTraverse {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归式 前序遍历
     * @param node
     * @param list
     */
    public void preOrderTraverse(TreeNode node, List<Integer> list) {
        if (node == null) return ;
        list.add(node.val);
        preOrderTraverse(node.left, list);
        preOrderTraverse(node.right, list);
    }

    /**
     * 非递归式 前序遍历
     * @param root
     * @param list
     */
    public void preOrderTraverse2(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                TreeNode p = stack.pop();
                root = p.right;
            }
        }
    }
}
