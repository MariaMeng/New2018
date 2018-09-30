package Algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 9/19/18.
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) return list;

        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(root.val);
        dfs(root, tmp, list, sum);

        return list;
    }

    public static void dfs(TreeNode root, ArrayList<Integer> tmp, List<List<Integer>> list, int sum) {
        if (root.left == null && root.right == null && root.val == sum) {
            list.add(new ArrayList<>(tmp));
            return ;
        }
        if (root.left != null) {
            tmp.add(root.left.val);
            dfs(root.left, tmp, list, sum - root.val);
            tmp.remove(tmp.size() - 1);
        }

        if (root.right != null) {
            tmp.add(root.right.val);
            dfs(root.right, tmp, list, sum - root.val);
            tmp.remove(tmp.size() - 1);
        }

    }
}
