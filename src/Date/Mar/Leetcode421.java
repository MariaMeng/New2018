package Date.Mar;

/**
 * @author mengxiang
 * @date 20/3/9
 */
class TreeNode {
    int val;
    TreeNode left, right;

}
public class Leetcode421 {

    public static void main(String[] args) {
        int[] data = new int[]{3, 10, 5, 25, 2, 8};
        int res = findMaximumXOR(data);
        System.out.println(res);
    }
    static TreeNode root = new TreeNode();

    public static int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 建立字典树过程
        for (int n: nums) {
            build(n);
        }

        // 查询最差异或
        int max = 0;
        for (int num: nums) {
            int val = find(num);
            max = Math.max(max, val);
        }
        return max;
    }

    public static int find(int num) {
        TreeNode node = root;
        int val = 0;
        int j = 1 << 30;
        for (int i = 0; i < 31; i++) {
            int bit = (num & j) == 0 ? 0: 1;
            if (bit == 0) {
                if (node.right != null) {
                    val <<= 1;
                    val += 1;
                    node = node.right;
                } else {
                    val <<= 1;
                    node = node.left;
                }
            }
            // bit == 1
            else {
                if (node.left != null) {
                    val <<= 1;
                    val += 1;
                    node = node.left;
                } else {
                    val <<= 1;
                    node = node.right;
                }
            }
            j >>= 1;
        }
        return val;
    }

    public static void build(int num) {
        TreeNode node = root;
        int cur = num;
        int j = 1 << 30;
        for (int i = 0; i < 31; i++) {
            int bit = (cur & j) == 0 ? 0: 1;
            if (bit == 0) {
                if (node.left == null) {
                    node.left = new TreeNode();
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode();
                }
                node = node.right;
            }
            j >>= 1;
        }
    }
}
