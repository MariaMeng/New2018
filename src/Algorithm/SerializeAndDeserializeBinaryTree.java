package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by apple on 9/24/18.
 * 采用四中方法序列化、反序列化二叉树：前序、中序、后序、层序遍历
 */
public class SerializeAndDeserializeBinaryTree {
    // 1. 使用前序遍历二叉树

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        serialize(root, sb);

        return sb.toString();

    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#!");
            return ;
        }
        sb.append(root.val + "!");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] list = data.split("!");
        int i = 0;

        int[] d = new int[1];
        d[0] = -1;
        TreeNode res = deserialize(list, d);

        return res;
    }
    public TreeNode deserialize(String[] list, int[] d) {
        d[0]++;

        if (d[0] >= list.length) return null;
        String tmp = list[d[0]];
        if (tmp.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(tmp));
        root.left = deserialize(list, d);
        root.right = deserialize(list, d);

        return root;
    }

    // 2. 使用层序遍历二叉树
    public static String serialize_B(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null)
                sb.append("#!");
            else {
                sb.append(node.val + "!");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();
    }

    public static TreeNode deserialize_B(String data) {
        if (data == null || data.length() == 0) return null;
        String[] list = data.split("!");

        int i = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = helper(list, i++);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) continue;

            node.left = helper(list, i++);
            node.right = helper(list, i++);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;

    }
    public static TreeNode helper(String[] list, int index) {
        if (index >= list.length) return null;
        String tmp = list[index];
        if (tmp.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(tmp));
        return node;
    }

    // 3. 如果为Binary Search Tree
    public static String serialize_C(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper1(sb, root);

        return sb.toString();
    }
    public static void helper1(StringBuilder sb, TreeNode root) {
        if (root == null) return ;
        sb.append(root.val + "!");

        helper1(sb, root.left);
        helper1(sb, root.right);
    }


    public static TreeNode deserialize_C(String data) {
        if (data == null || data.length() == 0) return null;
        String[] list = data.split("!");

        TreeNode res = helper2(list, 0, list.length - 1);
        return res;
    }

    public static TreeNode helper2(String[] list, int start, int end) {
        if (start > end) return null;
        if (start == end) {
            int val = Integer.valueOf(list[start]);
            TreeNode node = new TreeNode(val);
            return node;
        }
        int val = Integer.valueOf(list[start]);
        TreeNode node = new TreeNode(val);

        int i;
        for (i = start + 1; i <= end; i++) {
            int tmp = Integer.valueOf(list[i]);
            if (tmp > val) {
                break;
            }
        }
        node.left = helper2(list, start + 1, i - 1);
        node.right = helper2(list, i, end);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        String s = serialize4(node);
        System.out.println(s);
        TreeNode res = deserialize4(s);

        System.out.println(res);
    }



    // 4. new
    public static String serialize4(TreeNode root) {
        // write your code here
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(root, sb);

        return sb.toString();
    }
    public static void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return ;
        }
        sb.append(root.val);
        sb.append(",");

        helper(root.left, sb);
        helper(root.right, sb);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public static TreeNode deserialize4(String data) {
        // write your code here
        if (data == null || data.length() == 0)return null;

        String[] str = data.split(",");
        int[] d = new int[1];
        d[0] = -1;
        return helper2(str, d);

    }
    public static TreeNode helper2(String[] str, int[] d) {
        d[0]++;
        if (d[0] == str.length || str[d[0]].equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(str[d[0]]));
        root.left = helper2(str, d);
        root.right = helper2(str, d);

        return root;
    }
}
