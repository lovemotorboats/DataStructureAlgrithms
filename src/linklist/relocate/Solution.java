package linklist.relocate;

import linklist.printcommonpart.Node;

//将链表的左半区和右半区交叉重新组合
public class Solution {
    public static Node relocate(Node head){
        if (head == null || head.next == null || head.next.next == null)
            return head;
        Node mid = head;
        Node right = head.next;
        Node cur = head;
        Node next = null;
        while (right.next != null  && right.next.next != null){
            right = right.next.next;
            mid = mid.next;
        }
        right = mid.next;
        mid.next = null;
        while (cur.next != null){
            next = right.next;
            right.next = cur.next;
            cur.next = right.next;
            cur = right.next;
            right = next;
        }
        cur.next = next;
        return head;
    }
}
