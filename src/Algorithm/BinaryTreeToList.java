package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by apple on 9/25/18.
 * part one：
 * 滴滴面试三面
 * 剑指offer题目
 * 将二叉树按照中序遍历的顺序转成双向链表
 *
 * part two:
 * LeetCode 114
 * 将二叉树按照前序遍历转成单链表
 */
public class BinaryTreeToList {

    // 1. 将二叉树按照中序遍历转成双链表
    public TreeNode bianaryToList(TreeNode root) {
        TreeNode last = null;
        last = convert(root, last);

        while (last.left != null) {
            last = last.left;
        }
        return last;
    }

    public TreeNode convert(TreeNode root, TreeNode last ){
        if (root == null) return last;

        if (root.left != null)
            last = convert(root.left, last);

        root.left = last;
        if (last != null)
            last.right = root;

        last = root;
        if (root.right != null) {
            last = convert(root.right, last);
        }
        return last;
    }

    // 二叉树的中序遍历迭代法
    public static List<Integer> inorderTraversal(TreeNode root){
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while ( p!= null) {
                stack.push(p);
                p = p.left;
            }
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                p = node.right;
            }
        }
        return list;
    }

    // 2. 二叉树前序遍历转成单链表
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;

    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(inorderTraversal(root));
    }
}
