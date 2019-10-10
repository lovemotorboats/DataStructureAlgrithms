package binarytree.findtwoerrnode;

import binarytree.travel.Node;

import java.util.Stack;

//调整搜索二叉树中两个错误的结点
public class Solution {
    //一颗搜索二叉树有两个结点调换了位置，使得这颗二叉树不再是搜索二叉树，请找到这
    //两个结点并返回，这颗二叉树的每个结点的值都不一样
    public static Node[] getTwoErrNode(Node head){
        Node[] errs = new Node[2];
        if (head == null)
            return errs;
        Stack<Node> stack = new Stack<>();
        Node node = head;
        Node pre = null;
        while (!stack.isEmpty() || node != null){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                if (pre != null && pre.value > node.value) {
                    errs[0] = errs[0] == null ? pre : errs[0];
                    errs[1] = node;
                }
                pre = node;
                node = node.right;
            }
        }
        return errs;
    }

    //进阶问题：在结构上交换这两个结点（注意不是数值上交换）
    //思路：首先应该找到这两个结点的父节点，再随便改写一个二叉树遍历即可
    public static Node[] getTwoErrParents(Node head, Node e1, Node e2){
        //在二叉树head中找到e1和e2的父节点并返回
        Node[] parents = new Node[2];
        if (head == null)
            return parents;
        Stack<Node> stack = new Stack<>();
        Node node = head;
        while (!stack.isEmpty() || node != null){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                if (node.left == e1 || node.right == e1)
                    parents[0] = node;
                if (node.left == e2 || node.right == e2)
                    parents[1] = node;
                node = node.right;
            }
        }
        return parents;
    }


}
