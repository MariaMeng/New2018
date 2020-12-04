package Date.July.July282019;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by apple on 7/28/19.
 * 二叉树的中序遍历
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class InOrderyTraverse {

    /**
     * 二叉树的中序遍历 递归方式
     * @param root
     * @param list
     */
    public static void inorderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        inorderTraverse(root.left, list);
        list.add(root.val);
        inorderTraverse(root.right, list);
    }

    /**
     * 二叉树的中序遍历 非递归
     * @param root
     * @param list
     */
    public static void inorderTraverse2(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode p = stack.pop();
                list.add(p.val);
                root = p.right;
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

        inorderTraverse(root, list1);
        inorderTraverse2(root, list2);

        System.out.println(list1);
        System.out.println(list2);
    }

}
