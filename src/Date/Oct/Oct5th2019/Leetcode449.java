package Date.Oct.Oct5th2019;

/**
 * Created by apple on 10/5/19.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Leetcode449 {

    static int idx = 0;
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        serial(sb, root);
        return sb.toString();
    }

    public static void serial(StringBuilder sb, TreeNode root) {
        if (root == null) return ;
        sb.append(root.val + ",");
        serial(sb, root.left);
        serial(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] strs = data.split(",");

        TreeNode root = deserial(strs, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }

    public static TreeNode deserial(String[] strs, int min, int max) {
        if (idx >= strs.length || strs[idx] == null || strs[idx].equals("") || Integer.valueOf(strs[idx]) > max) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(strs[idx++]));
        root.left = deserial(strs, min, root.val);
        root.right = deserial(strs, root.val, max);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        String res = serialize(root);
        System.out.println(res);

        TreeNode de = deserialize(res);
        System.out.println(de.val);
    }
}
