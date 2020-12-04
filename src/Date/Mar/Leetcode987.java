package Date.Mar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author mengxiang
 * @date 20/3/28
 */
public class Leetcode987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        traverse(root, 0, 0, map);
        for (int key: map.keySet()) {
            TreeMap<Integer, List<Integer>> tmp = map.get(key);
            List<Integer> list = new ArrayList<>();
            for (int k: tmp.keySet()) {
                list.addAll(tmp.get(k));
            }
            res.add(list);
        }
        return res;
    }

    public void traverse(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (root == null) {
            return ;
        }
        TreeMap<Integer, List<Integer>> tmp = map.get(x);
        if (tmp == null) {
            tmp = new TreeMap<>((a, b) -> b - a);
            map.put(x, tmp);
        }
        List<Integer> list = tmp.get(y);
        if (list == null) {
            list = new ArrayList<>();
            tmp.put(y, list);
        }
        list.add(root.val);

        traverse(root.left, x - 1, y - 1, map);
        traverse(root.right, x + 1, y - 1, map);
    }

    public static void main(String[] args) {

    }
}
