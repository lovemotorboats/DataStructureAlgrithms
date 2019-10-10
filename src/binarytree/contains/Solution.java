package binarytree.contains;

import binarytree.travel.Node;

//给定两颗二叉树h1和h2，判断h1是否包含h2的完整的拓扑结构
public class Solution {
    public static boolean contains(Node head1, Node head2){
        if (head2 == null)
            return true;
        if (head1 == null)
            return false;
        return check(head1, head2) || contains(head1.left, head2) || contains(head1.right, head2);
    }

    public static boolean check(Node h, Node t){
        //判断树h从头节点开始是否包含有和t相同的拓扑结构
        if (t == null)
            return true;
        if (h == null || h.value != t.value)
            return false;
        return check(h.left, t.left) && check(h.right, t.right);
    }
}
