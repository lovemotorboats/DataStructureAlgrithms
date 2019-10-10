package binarytree.biggestsearchbinarytree;

import binarytree.travel.Node;


//树形dp套路四步：
//1、分析有哪些可能，答案可能来自左子树，可能来自右子树，也可能就是整棵树
//2、根据第一步的可能性分析，列出所有需要的信息
//3、合并第二步的信息，为信息设计新的数据结构
//4、设计递归函数
public class Solution {
    public static ReturnType process(Node X){
        if (X == null)
            return new ReturnType(null, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        //默认直接获取到左树的全部信息
        ReturnType leftData = process(X.left);
        //默认直接获取到右树的全部信息
        ReturnType rightData = process(X.right);
        int min = Math.min(X.value, Math.min(leftData.min, rightData.min));
        int max = Math.max(X.value, Math.max(leftData.max, rightData.max));
        int maxBSTSize = Math.max(leftData.max, rightData.max);
        Node maxBSTHead = leftData.maxBSTSize >= rightData.maxBSTSize ? leftData.maxBSTHead : rightData.maxBSTHead;
        if (leftData.maxBSTHead == X.left && rightData.maxBSTHead == X.right && leftData.max < X.value && rightData.min > X.value){
            maxBSTSize = leftData.maxBSTSize + rightData.maxBSTSize + 1;
            maxBSTHead = X;
        }
        return new ReturnType(maxBSTHead, maxBSTSize, min, max);
    }

    public static Node getMaxBST(Node head){
        return process(head).maxBSTHead;
    }
}
