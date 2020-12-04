package Date.Oct.Oct4th2019;

/**
 * Created by apple on 10/4/19.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Leetcode297 {



    public static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serial(sb, root);
        return sb.toString();

    }

    public static void serial(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append("#!");
            return ;
        }

        sb.append(root.val + "!");
        serial(sb, root.left);
        serial(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] strs = data.split("!");

        int[] start = new int[1];
        start[0] = 0;
        TreeNode root = deserial(strs, start);
        return root;
    }

    public static TreeNode deserial(String[] strs, int[] s) {
        int idx = s[0]++;
        if (strs[idx].equals("#")) return null;

        TreeNode root = new TreeNode(Integer.valueOf(strs[idx]));


        root.left = deserial(strs, s);
        root.right = deserial(strs, s);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        String str = serialize(root);
        System.out.println("res" + str);

        TreeNode res = deserialize(str);
        System.out.println(res.val);
    }
}
