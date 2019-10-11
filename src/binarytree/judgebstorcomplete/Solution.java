package binarytree.judgebstorcomplete;

import binarytree.travel.Node;

import java.util.LinkedList;
import java.util.Queue;

//判断一颗二叉树是否为平衡二叉树或者完全二叉树
public class Solution {
    //判断是否为平衡二叉树
    //改写中序遍历，利用morris遍历改写，只要发现降序就返回false
    public static boolean isBST(Node head){
        if (head == null)
            return true;
        boolean res = true;
        Node pre = null;
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }
            if (pre != null && pre.value > cur.value)
                res = false;
            pre = cur;
            cur = cur.right;
        }
        return res;
    }

    //判断是否为完全二叉树
    //1、按层序遍历二叉树
    //2、如果当前结点有右孩子结点没有左孩子结点，返回false
    //3、如果当前结点不是左右孩子全有，那么之后的结点必须都为叶节点，否则返回false
    //4、遍历结束不返回false，则返回true
    public static boolean isCBT(Node head){
        if (head == null)
            return true;
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node left = null;
        Node right = null;
        Node node = head;
        queue.offer(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            left = node.left;
            right = node.right;
            if ((leaf && (left != null || right != null)) || (left == null && right != null)){
                return false;
            }
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
            else leaf = true;
        }
        return true;
    }
}
