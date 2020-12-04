package Date.July.July242019;

/**
 * Created by apple on 7/24/19.
 */
public class Leetcode99 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }
    TreeNode firstElement = null, secondElement = null;
    TreeNode preElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        if (root == null) return ;
        traverse(root);
        // swap the value of two node
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    private void traverse(TreeNode root) {
        if (root == null) return ;
        traverse(root.left);
        // do something here
        // 找到第一个元素 出现 比之前大的
        if (firstElement == null && preElement.val > root.val) {
            firstElement = preElement;
        }
        if (preElement.val > root.val) {
            secondElement = root;
        }
        preElement = root;
        traverse(root.right);
    }

    // -----------------------------------方法二-----------------------------------
    private TreeNode prev;
    private TreeNode firstNode;
    private TreeNode lastNode;
    public void recoverTree1(TreeNode root) {
        inOrder(root);
        int temp = firstNode.val;
        firstNode.val = lastNode.val;
        lastNode.val = temp;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (prev != null && prev.val > node.val) {
            if (firstNode == null) {
                firstNode = prev;
            }
            lastNode = node;
        }
        prev = node;
        inOrder(node.right);
    }
}
