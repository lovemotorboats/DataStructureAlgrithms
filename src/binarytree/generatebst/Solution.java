package binarytree.generatebst;

import binarytree.travel.Node;

public class Solution {
    //给定一个有序数组sortArr，已知其中没有重复值，用这个有序数组生成一颗平衡搜索
    //二叉树，并且该搜索二叉树中序遍历结果与sortArr一致

    public static Node generateTree(int[] sortArr){
        if (sortArr == null)
            return null;
        return generate(sortArr, 0, sortArr.length - 1);
    }

    //用有序数组中最中间的树生成搜索二叉树的根节点，然后用其左边的数生成左子树
    //用右边的数生成右子树，递归实现
    public static Node generate(int[] sortArr, int start, int end){
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node head = new Node(sortArr[mid]);
        head.left = generate(sortArr, start, mid - 1);
        head.right = generate(sortArr, mid + 1, end);
        return head;
    }
}
