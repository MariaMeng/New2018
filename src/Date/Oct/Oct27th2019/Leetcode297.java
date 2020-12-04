package Date.Oct.Oct27th2019;

import java.util.PriorityQueue;

/**
 * Created by apple on 10/27/19.
 */

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class Leetcode297 {
    int start = -1;
    String Serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        serial(root, sb);
        return sb.toString();
    }
    void serial(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            return ;
        }

        sb.append(root.val + "#");
        serial(root.left, sb);
        serial(root.right, sb);
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) return null;
        String[] strs = str.split("#");
        return deserial(strs);
    }
    public TreeNode deserial(String[] strs) {
        start++;
        if (start >= strs.length || strs[start].length() == 0) return null;
        int val = Integer.valueOf(strs[start]);
        TreeNode root = new TreeNode(val);

        root.left = deserial(strs);
        root.right = deserial(strs);
        return root;
    }

    public static void main(String[] args) {
        Leetcode297 leet = new Leetcode297();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String str = leet.Serialize(root);
        System.out.println(str);

        TreeNode node = leet.Deserialize(str);
        System.out.println(node.val);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
    }

}
