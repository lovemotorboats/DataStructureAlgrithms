package linklist.intersectlinklist;

import linklist.printcommonpart.Node;

//两个单链表相交的一系列问题
public class Solution {
    //判断一个单链表是否有环，如果有环就返回第一个进入环的结点，没有则返回null
    public static Node getLoopNode(Node head){
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next == head) {
            return head;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //判断两个无环链表是否相交，相交返回第一个相交结点，否则返回null
    public static Node noLoop(Node head1, Node head2){
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1, cur2 = head2;
        while (cur1 != cur2) {
            cur1 = cur1 == null ? head2 : cur1.next;
            cur2 = cur2 == null ? head1 : cur2.next;
        }
        return cur1;
    }
    //判断两个有环链表是否相交，相交返回第一个相交的结点，否则返回null
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1.next != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop1){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == cur2)
                    return cur1;
                cur1 = cur1.next;
            }
            return null;
        }
    }
    //判断两个链表是否相交，相交则返回第一个相交的结点，否则返回null
    public Node getIntersectNode(Node head1, Node head2){
        if (head1 == null || head2 == null)
            return null;
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null)
            //两个链表都不存在环
            return noLoop(head1, head2);
        if (loop1 != null && loop2 != null)
            //两个链表都存在环
            return bothLoop(head1, loop1, head2, loop2);
        return null;
    }
}
