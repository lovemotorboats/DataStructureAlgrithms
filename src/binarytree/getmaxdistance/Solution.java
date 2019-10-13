package binarytree.getmaxdistance;

import binarytree.travel.Node;

//寻找二叉树中任意两个结点间的最大距离
public class Solution {
    //树形dp套路
    //可能性1：以X为头节点的子树，最大距离可能是左子树上的最大距离
    //可能性2：以X为头节点的子树，最大距离可能是右子树上的最大距离
    //可能性3：以X为头节点的子树，最大距离可能是左子树上离X最远的结点
    // 到右子树上离X最远距离的结点间的距离
    public ReturnType process(Node head){
        if (head == null)
            return new ReturnType(0, 0);
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int maxDistance = Math.max(Math.max(leftData.maxDistance, rightData.maxDistance), leftData.height + rightData.height + 1);
        return new ReturnType(maxDistance, height);
    }

    public int getMaxDistance(Node head){
        return process(head).maxDistance;
    }
}
