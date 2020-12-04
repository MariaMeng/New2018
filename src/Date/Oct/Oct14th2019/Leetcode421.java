package Date.Oct.Oct14th2019;

/**
 * Created by apple on 10/14/19.
 */

public class Leetcode421 {

    class TrieNode {
        int val;
        TrieNode zero, one;
        boolean leaf;
    }
    public void insert(TrieNode root, int num) {
        int j = 1 << 30;
        for (int i = 0; i < 31; i++) {
            // 异或之后 不用移动，只要判断是否为 0即可
            int b = (num & j) == 0 ? 0 : 1;

            if (b == 0 && root.zero == null) {
                root.zero = new TrieNode();
            }
            else if (b == 1 && root.one == null) {
                root.one = new TrieNode();
            }
            root = (b == 0) ? root.zero: root.one;
            j >>= 1;
        }
        root.leaf = true;
        root.val = num;
    }

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        TrieNode root = new TrieNode();
        // build the trie tree
        for (int num: nums) {
            insert(root, num);
        }

        // find the first diff bit from high bit signficant

        while (root.zero == null || root.one == null) {
            root = root.zero == null ? root.one: root.zero;
        }

        // search the trie
        int max = search(root.zero, root.one);
        return max;
    }

    public int search(TrieNode zero, TrieNode one) {
        if (zero.leaf && one.leaf) {
            return zero.val ^ one.val;
        }
        if (zero.zero == null) {
            return search(zero.one, one.zero == null? one.one: one.zero);
        }
        if (zero.one == null) {
            return search(zero.zero, one.one == null ? one.zero: one.one);
        }
        if (one.zero == null) {
            return search(zero.zero, one.one);
        }
        if (one.one == null) {
            return search(zero.one, one.zero);
        }
        else{
            return Math.max(search(zero.one, one.zero), search(zero.zero, one.one));
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        Leetcode421 l = new Leetcode421();
        l.findMaximumXOR(nums);
    }
}
