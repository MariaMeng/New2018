package Date.Mar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengxiang
 * @date 20/3/23
 */

public class Main1 {

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    int len  = 0;
    public List<List<Integer>> findPath(TreeNode root, TreeNode node, int k) {
        if (root == null || node == null || k <= 0) return null;

        List<List<Integer>> list = new ArrayList<>();
        find(root, node, k, list, new ArrayList<>());
        return list;
    }


    public void help(TreeNode node, int k, List<List<Integer>> list, List<Integer> tmp) {
        if (k == 0) {
            list.add(new ArrayList<>(tmp));
            return ;
        }
        if (node == null) return ;
        tmp.add(node.val);
        help(node.left, k - 1, list, tmp);
        help(node.right, k - 1, list, tmp);
        tmp.remove(tmp.size() - 1);
    }

    public int  find(TreeNode root, TreeNode node, int k, List<List<Integer>> list, ArrayList<Integer> tmp) {
        if (root == null) return -1;
        if (root == node) {
            help(node, k, list, tmp);
            tmp.add(node.val);
            return k;
        }
        len++;
        int  left = find(root.left, node, k, list, tmp);
        int  right = find(root.right, node, k, list, tmp);

        if (left < 0 && right < 0) {
            return -1;
        }
        if (left > 0) {
            if (left == 1) tmp.add(root.val);
            else help(root.right, k - 2, list, tmp);
            return left - 1;
        } else {
            if (right == 1) tmp.add(root.val);
            else help(root.left, k - 2, list, tmp);
            return right - 1;
        }

    }
}
