package linklist.reversepartlinklist;

import linklist.printcommonpart.Node;

//给定一单链表head，以及两个整数from和to，将第from到第to个节点这部分反转
public class Solution {
    public static Node reversePartLinklist(Node head, int from, int to){
        int len = 0;
        Node node1 = head;
        Node pre = null;
        Node pos = null;
        while (node1 != null){
            len++;
            if (len == from - 1)
                pre = node1;  //1、先找到from的前驱节点和to的后继节点
            if (len == to + 1)
                pos = node1;
            node1 = node1.next;
        }
        if (len < to || from > to || from < 1)  //参数不正确
            return head;
        node1 = pre == null? head : pre.next;
        Node node2 = node1.next;
        node1.next = pos;
        Node next = null;
        while (node2 != null){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (pre != null){
            pre.next = node1;
            return head;  //不用换头
        }else return node1;
    }
}
