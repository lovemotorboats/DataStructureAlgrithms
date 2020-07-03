package binarytree.maxpathsum;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/*
 * @description:给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 * @author:liyang
 * @create:2020-06-18
 */
class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        oneSideMax(root);
        return max;
    }

    //返回 从下到上找一条路径，路径的终节点为root(必选)，可以获得的最大路径和
    public int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = oneSideMax(root.left) > 0 ? oneSideMax(root.left) : 0;
        int rightMax = oneSideMax(root.right) > 0 ? oneSideMax(root.right) : 0;

        max = (root.val + leftMax + rightMax) > max ? (root.val + leftMax + rightMax) : max;
        return root.val + (leftMax > rightMax ? leftMax : rightMax);
    }

}

