package binarytree.isbalancetree;

import binarytree.travel.Node;

//平衡二叉树的性质为：要么是一颗空树，要么任何一个结点的左右子树的高度差的绝对值不超过1
//本题可以使用树形dp套路
public class Solution {
    //一、分析可能性：
    //1、左子树不平衡，则此树不平衡
    //2、右子树不平衡，则此树不平衡
    //3、左子树和右子树高度差超过1，则此树不平衡
    //4、上面三种都没中，则此树平衡
    //二、列出需要的信息：是否平衡、高度
    //三、信息汇总
    //四、设计递归函数
    public static ReturnType process(Node head){
        if (head == null)
            return new ReturnType(true, 0);
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }

    public static boolean isBalanced(Node head){
        return process(head).isBalanced;
    }
}
