package Date.July.July282019;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by apple on 7/28/19.
 * 二叉树的后续遍历
 */

public class PostOrderTraverse {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归方式 遍历二叉树
     * @param root
     * @param list
     */
    public static void postOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) return ;

        postOrderTraverse(root.left, list);
        postOrderTraverse(root.right, list);
        list.add(root.val);
    }

    /**
     * 非递归方式 遍历二叉树
     * 双栈方法
     * @param root
     * @param list
     */
    public static void postOrderTraverse2(TreeNode root, List<Integer> list) {
        if (root == null) return ;

        //  中右左 辅助栈
        Stack<TreeNode> stack1 = new Stack<>();
        // 保存 中右左 顺序
        Stack<TreeNode> stack2 = new Stack<>();

        while (!stack1.isEmpty() || root != null) {
            if (root != null) {
                stack1.push(root);
                stack2.push(root);
                root = root.right;
            } else {
                TreeNode p = stack1.pop();
                root = p.left;
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
    }

    public void postOrderTraverse3(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode h = root, c = null;
        while (!stack.isEmpty()) {
            c = stack.peek();

            if (c.left != null && c.left != h && c.right != h) {
                stack.push(c.left);
                c = c.left;
            } else if (c.right != null && c.right != h) {
                stack.push(c.right);
                c = c.right;
            } else {
                h = stack.pop();
                list.add(h.val);
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        postOrderTraverse(root, list1);
        postOrderTraverse(root, list2);
        postOrderTraverse2(root, list3);

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }
}
