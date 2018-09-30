package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by apple on 9/25/18.
 * part one��
 * �ε���������
 * ��ָoffer��Ŀ
 * ���������������������˳��ת��˫������
 *
 * part two:
 * LeetCode 114
 * ������������ǰ�����ת�ɵ�����
 */
public class BinaryTreeToList {

    // 1. �������������������ת��˫����
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

    // ���������������������
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

    // 2. ������ǰ�����ת�ɵ�����
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
