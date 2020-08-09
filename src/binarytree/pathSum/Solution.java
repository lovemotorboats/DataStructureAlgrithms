package binarytree.pathSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //递归
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            LinkedList<Integer> newList = new LinkedList<>();
            newList.addFirst(root.val);
            res.add(newList);
        }
        List<List<Integer>> leftRes = pathSum(root.left, sum - root.val);  //从左子树到叶节点路径和等于sum-root.val
        List<List<Integer>> rightRes = pathSum(root.right, sum - root.val);
        for (List<Integer> list : leftRes) {
            ((LinkedList)list).addFirst(root.val);
            res.add(list);
        }
        for (List<Integer> list : rightRes) {
            ((LinkedList)list).addFirst(root.val);
            res.add(list);
        }

        return res;
    }
}

//二叉树结点数据结构
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data){
        val = data;
    }
}
