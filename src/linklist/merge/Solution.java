package linklist.merge;

import linklist.printcommonpart.Node;

//将两个有序单链表合并，保持合并后的单链表依然有序
public class Solution {
    public static Node merge(Node head1, Node head2){
        if (head1 == null || head2 == null)
            return head1 == null ? head2 : head1;
        Node newHead = head1.value < head2.value ? head1 : head2;
        Node cur1 = newHead;
        Node cur2 = cur1 == head1 ? head2 : head1;
        Node pre = null;
        Node next = null;
        while (cur1 != null && cur2 != null){
            if (cur1.value < cur2.value){
                pre = cur1;
                cur1 = cur1.next;
            }else {
                next = cur2.next;
                pre.next = cur2;
                pre = pre.next;
                cur2.next = cur1;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return newHead;
    }
}
