package linklist;
/*
 * @description:排序链表（快排）
 * @author:liyang
 * @create:2020-08-24
 */

import linklist.printcommonpart.Node;

public class sortList {

    public static Node cut(Node head, int k) {
        //切掉head的前k个节点，返回后面那一段的头
        Node cur = head;
        while (--k != 0 && cur != null) {
            cur = cur.next;
        }
        if (cur == null) {
            return null;
        }
        Node next = cur.next;
        cur.next = null;
        return next;
    }

    public static Node merge(Node head1, Node head2) {
        //合并两个有序链表
        Node dummy = new Node(0);
        Node p = dummy, p1 = head1, p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.value <= p2.value) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            }else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }

        p.next = p1 == null ? p2 : p1;
        return dummy.next;
    }

    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }

        for (int size = 1; size < len; size <<= 2) {
            Node cur = dummy.next, tail = dummy;
            while (cur != null) {
                Node left = cur;
                Node right = cut(cur, size);
                cur = cut(right, size);
                tail.next = merge(left, right);
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }

        return dummy.next;
    }
}
