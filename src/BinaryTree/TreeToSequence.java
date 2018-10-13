package BinaryTree;

import java.util.*;

/**
 * Created by apple on 10/7/18.
 */
class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
    }
}
public class TreeToSequence {

    public static int[][] convert(TreeNode root) {
        // write code here
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        preOrder(root, pre);
        inOrder(root, in);
        postOrder(root, post);
        int[][] res = new int[3][pre.size()];
        for (int i = 0; i < pre.size(); i++) {
            res[0][i] = pre.get(i);
        }
        for (int i = 0; i < pre.size(); i++) {
            res[1][i] = in.get(i);

        }
        for (int i = 0; i < pre.size(); i++)
            res[2][i] = post.get(i);
        return res;
    }
    public static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public static void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int[][] res = convert(root);
        for (int[] r : res) {
            for (int j : r) {
                System.out.println(j);
            }
        }
    }
}
